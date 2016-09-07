package com.srmarlins.weather.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.srmarlins.weather.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jared on 9/6/2016.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_title_text)
    TextView titleText;

    @BindView(R.id.content_container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(R.layout.activity_base);
        container = ButterKnife.findById(this, R.id.content_container);
        View view = LayoutInflater.from(this).inflate(layoutResId, null);
        container.addView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setTitle(CharSequence title) {
        titleText.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        titleText.setText(getString(titleId));
    }
}
