package com.example.hantun.myapplication.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.hantun.myapplication.data.paging.MovieTypeDataSource;
import com.example.hantun.myapplication.data.paging.MovieTypeDataSourceFactorty;
import com.example.hantun.myapplication.data.remote.api.MovieApiService;
import com.example.hantun.myapplication.data.remote.api.RetrofitBuilder;
import com.example.hantun.myapplication.data.remote.modelVO.MovieDetailVO;
import com.example.hantun.myapplication.data.remote.modelVO.MovieTypeVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private MovieApiService movieApiService;
    private static MovieRepository repository;

    private LiveData<PagedList<MovieTypeVO>> movieTypeList ;
    final MutableLiveData<MovieDetailVO> movieDetailVOLiveData = new MutableLiveData<>();
    private MutableLiveData<MovieTypeDataSource> movieTypeDataSource = new MutableLiveData<>();

    public MovieRepository(MovieApiService api) {
        movieApiService = api;
    }

    public static MovieRepository getInstance() {
        if (repository == null) {
            MovieApiService  movieApiService = RetrofitBuilder.buildService(MovieApiService.class);

            repository = new MovieRepository(movieApiService);
        }

        return repository;
    }

    public LiveData<PagedList<MovieTypeVO>> getMovieType(){
        MovieTypeDataSourceFactorty movieTypeDataSourceFactorty = new MovieTypeDataSourceFactorty();
        movieTypeDataSource = movieTypeDataSourceFactorty.movieTypeDataSourceMutableLiveData;

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(MovieTypeDataSource.PAGE_SIZE)
                .build();

        return movieTypeList = new LivePagedListBuilder<>(movieTypeDataSourceFactorty , config).build();

    }
    public LiveData<MovieDetailVO> getMovieDetail(int movieId){

        movieApiService.getMovieDetail(movieId).enqueue(new Callback<MovieDetailVO>() {
            @Override
            public void onResponse(Call<MovieDetailVO> call, Response<MovieDetailVO> response) {
                movieDetailVOLiveData.postValue(response.body());

            }

            @Override
            public void onFailure(Call<MovieDetailVO> call, Throwable t) {

            }
        });

        return movieDetailVOLiveData;
    }


}
