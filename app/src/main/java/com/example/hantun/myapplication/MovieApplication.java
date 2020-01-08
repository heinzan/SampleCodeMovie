package com.example.hantun.myapplication;

import com.example.hantun.myapplication.di.components.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MovieApplication extends DaggerApplication{

    private static MovieApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static synchronized MovieApplication getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}