package com.example.hantun.myapplication.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.hantun.myapplication.AppConstants;
import com.example.hantun.myapplication.R;
import com.example.hantun.myapplication.data.remote.modelVO.MovieDetailVO;
import com.example.hantun.myapplication.util.ChangeTime;
import com.example.hantun.myapplication.viewmodels.MovieDetailViewModel;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MovieDetailFragment extends com.example.hantun.myapplication.ui.base.BaseFragment {


    private int movie_id;
    private ImageView iv_background;
    private TextView tv_title , tv_overview , tv_duration ,tv_release , tv_language , tv_status;
    private MovieDetailViewModel movieDetailViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         movie_id = this.getArguments().getInt("movie_id");
        View rootView = inflater.inflate(R.layout.frag_movie_detail, container, false);
        initView(rootView);
        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel.class);
        movieDetailViewModel.fetchMovieDetail(movie_id);
        movieDetailViewModel.getMovieDetail().observe(this, new Observer<MovieDetailVO>() {
            @Override
            public void onChanged(MovieDetailVO movieDetailVO) {
                putData(movieDetailVO);
            }
        });

        return rootView;
    }

    private void initView(View v) {
        iv_background = v.findViewById(R.id.iv_background);
        tv_title = v.findViewById(R.id.tv_movie_title);
        tv_overview = v.findViewById(R.id.tv_overview);
        tv_duration = v.findViewById(R.id.tv_duration);
        tv_release = v.findViewById(R.id.tv_release);
        tv_language = v.findViewById(R.id.tv_language);
        tv_status = v.findViewById(R.id.tv_status);

    }

    private void putData(MovieDetailVO movieDetailVO) {
        Picasso.get().load(AppConstants.TMDB_IMAGE_URL+movieDetailVO.getBackdropPath()).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(iv_background);

        tv_duration.setText(ChangeTime.MinToHour(movieDetailVO.getRuntime()));
        tv_release.setText(movieDetailVO.getReleaseDate());
        tv_language.setText(movieDetailVO.getSpokenLanguages().get(0).getName());
        tv_status.setText(movieDetailVO.getStatus());
        tv_title.setText(movieDetailVO.getOriginalTitle());
        tv_overview.setText(movieDetailVO.getOverview());
    }

}
