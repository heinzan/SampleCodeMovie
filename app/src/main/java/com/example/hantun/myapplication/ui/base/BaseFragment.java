package com.example.hantun.myapplication.ui.base;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.example.hantun.myapplication.AppConstants;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}