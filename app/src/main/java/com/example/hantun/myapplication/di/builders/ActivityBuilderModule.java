package com.example.hantun.myapplication.di.builders;

import com.example.hantun.myapplication.ui.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
