package com.example.hantun.myapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hantun.myapplication.data.remote.modelVO.MovieDetailVO;
import com.example.hantun.myapplication.data.repository.MovieRepository;

public class MovieDetailViewModel extends ViewModel {
    private MovieRepository mMovieRepository;
    private LiveData<MovieDetailVO> movieDetailVOLiveData;


    public void fetchMovieDetail(int movieId){
        mMovieRepository = MovieRepository.getInstance();
        movieDetailVOLiveData = mMovieRepository.getMovieDetail(movieId);
    }

    public LiveData<MovieDetailVO> getMovieDetail(){
        return movieDetailVOLiveData;
    }

}
