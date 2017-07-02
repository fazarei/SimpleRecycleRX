package com.example.farzi.testsimplerecycleview.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farzi.testsimplerecycleview.R;
import com.example.farzi.testsimplerecycleview.model.FlowerResponse;
import com.example.farzi.testsimplerecycleview.service.FlowerService;
import com.example.farzi.testsimplerecycleview.ui.MainActivity;
import com.example.farzi.testsimplerecycleview.ui.adapter.FlowerAdapter;
import com.example.farzi.testsimplerecycleview.ui.presenters.MainPresenter;
import com.example.farzi.testsimplerecycleview.ui.presenters.MainPresenterImp;
import com.example.farzi.testsimplerecycleview.ui.views.MainView;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Farzi on 28/06/2017.
 */

public class MainFragment extends Fragment implements MainView {
    private MainPresenter presenter;
    RecyclerView mRecyclerView;
    private FlowerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        presenter = getMainPresenter();
        View view = inflater.inflate(R.layout.fragment_main,viewGroup,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        configView();
        presenter.loadFlowers();
        return view;
    }

    private void configView() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(getActivity().getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    protected MainPresenter getMainPresenter() {
        return new MainPresenterImp(this);
    }

    @Override
    public Context getContext(){
        return getActivity();
    }

    @Override
    public void onFlower(List<FlowerResponse> flowerResponses) {
        mAdapter.addFlower(flowerResponses);
        Log.d("LEE","come to Fragment");
    }

}
