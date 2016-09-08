package com.srmarlins.weather.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srmarlins.weather.R;
import com.srmarlins.weather.network.model.Forecast;
import com.srmarlins.weather.ui.adapter.ForecastRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Jared on 9/7/2016.
 */

public class ForecastBarFragment extends Fragment {

    public static final String FORECAST_TAG = "forecast_tag";


    @BindView(R.id.recycler_forecast)
    RecyclerView recyclerView;

    private ForecastRecyclerAdapter adapter;
    private ForecastDetailListener forecastDetailListener;
    private Observable<View> positionClickListener;

    public static ForecastBarFragment newInstance(ArrayList<Forecast> forecastList) {
        ForecastBarFragment forecastBarFragment = new ForecastBarFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(FORECAST_TAG, forecastList);
        forecastBarFragment.setArguments(args);
        return forecastBarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_bar, container, false);
        ButterKnife.bind(this, view);
        adapter = new ForecastRecyclerAdapter();
        Bundle args = getArguments();
        if (args != null) {
            ArrayList<Forecast> forecasts = getArguments().getParcelableArrayList(FORECAST_TAG);
            adapter.setData(forecasts);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        positionClickListener = adapter.getPositionClicks();
        positionClickListener.subscribe(new Subscriber<View>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(View view) {
                Forecast forecast = (Forecast) view.getTag();
                forecastDetailListener.onForecastSelected(forecast);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ForecastDetailListener) {
            forecastDetailListener = (ForecastDetailListener) context;
        }
    }

    public void updateForecastDetails(List<Forecast> forecastDetails) {
        this.adapter.setData(forecastDetails);
        this.adapter.notifyDataSetChanged();
    }

    public interface ForecastDetailListener {
        void onForecastSelected(Forecast forecast);
    }
}
