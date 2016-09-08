package com.srmarlins.weather.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.srmarlins.weather.R;
import com.srmarlins.weather.network.model.Forecast;
import com.srmarlins.weather.network.model.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Jared on 9/6/2016.
 */

public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastRecyclerAdapter.ViewHolder> {

    private List<Forecast> data = new ArrayList<>();
    private final PublishSubject<View> onClickSubject = PublishSubject.create();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Forecast forecast = data.get(position);
        forecast.setCode(forecast.getCode());
        Picasso.with(holder.itemView.getContext()).load(forecast.getForecastConditionIconURL()).into(holder.weatherImage);
        holder.high.setText(Integer.toString(forecast.getHigh()) + "\u00B0");
        holder.low.setText(Integer.toString(forecast.getLow())+ "\u00B0");
        holder.day.setText(forecast.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(forecast);
                onClickSubject.onNext(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Forecast> weatherInfo) {
        data = weatherInfo;
    }

    public Observable<View> getPositionClicks() {
        return onClickSubject.asObservable();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_high)
        TextView high;
        @BindView(R.id.textView_low)
        TextView low;
        @BindView(R.id.textView_day)
        TextView day;
        @BindView(R.id.imageView_weather)
        ImageView weatherImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
