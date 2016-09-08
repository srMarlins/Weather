package com.srmarlins.weather.ui.adapter;

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

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.ViewHolder> {

    private List<WeatherInfo> data = new ArrayList<>();
    private final PublishSubject<View> onClickSubject = PublishSubject.create();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WeatherInfo info = data.get(position);
        Forecast forecast = info.getItem().getForecast().get(0);
        holder.degrees.setText(info.getItem().getCondition().getTemp() + "\u00B0");
        holder.humidity.setText(info.getAtmosphere().getHumidity());
        holder.pressure.setText(info.getAtmosphere().getPressure());
        forecast.setCode(forecast.getCode());
        Picasso.with(holder.itemView.getContext()).load(forecast.getForecastConditionIconURL()).into(holder.weatherImage);
        holder.location.setText(info.getLocation().getCity() + ", " + info.getLocation().getRegion());
        holder.weatherType.setText(forecast.getText());
        holder.wind.setText(info.getWind().getSpeed());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(info);
                onClickSubject.onNext(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItem(WeatherInfo weatherInfo) {
        data.add(0, weatherInfo);
    }

    public void removeItem(WeatherInfo weatherInfo) {
        data.remove(weatherInfo);
    }

    public void setData(List<WeatherInfo> weatherInfo) {
        data = weatherInfo;
    }

    public Observable<View> getPositionClicks() {
        return onClickSubject.asObservable();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_wind)
        TextView wind;
        @BindView(R.id.textView_humidity)
        TextView humidity;
        @BindView(R.id.textView_pressure)
        TextView pressure;
        @BindView(R.id.weather_image)
        ImageView weatherImage;
        @BindView(R.id.textView_location)
        TextView location;
        @BindView(R.id.textView_weather_type)
        TextView weatherType;
        @BindView(R.id.textView_degrees)
        TextView degrees;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
