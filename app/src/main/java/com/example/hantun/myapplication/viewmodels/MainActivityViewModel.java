package com.example.hantun.myapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.hantun.myapplication.data.remote.modelVO.MovieTypeVO;
import com.example.hantun.myapplication.data.repository.MovieRepository;

public class MainActivityViewModel extends ViewModel {
    private MovieRepository mMainRepository;

    public MainActivityViewModel() {
        mMainRepository = MovieRepository.getInstance();
    }

    public LiveData<PagedList<MovieTypeVO>> getMovie() {
        return mMainRepository.getMovieType();
    }


}
