package com.srmarlins.weather.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.srmarlins.weather.network.model.WeatherInfo;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Jared on 9/6/2016.
 */

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherInfo> {

    private final PublishSubject<View> onClickSubject = PublishSubject.create();

    @Override
    public WeatherInfo onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WeatherInfo holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public Observable<View> getPositionClicks() {
        return onClickSubject.asObservable();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
