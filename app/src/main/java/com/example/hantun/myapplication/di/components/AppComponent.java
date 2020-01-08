package com.example.hantun.myapplication.di.components;

import android.app.Application;

import com.example.hantun.myapplication.MovieApplication;
import com.example.hantun.myapplication.di.builders.ActivityBuilderModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        modules = {
                AndroidSupportInjectionModule.class ,
                ActivityBuilderModule.class
        }

)
public interface AppComponent extends AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
