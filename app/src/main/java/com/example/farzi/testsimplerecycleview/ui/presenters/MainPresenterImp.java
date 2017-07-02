package com.example.farzi.testsimplerecycleview.ui.presenters;

import android.util.Log;

import com.example.farzi.testsimplerecycleview.model.FloweResponseData;
import com.example.farzi.testsimplerecycleview.model.FlowerResponse;
import com.example.farzi.testsimplerecycleview.service.FlowerService;
import com.example.farzi.testsimplerecycleview.service.ServiceFactory;
import com.example.farzi.testsimplerecycleview.ui.fragments.MainFragment;
import com.example.farzi.testsimplerecycleview.ui.views.MainView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Farzi on 28/06/2017.
 */

public class MainPresenterImp implements MainPresenter {
    private MainView mainView;
    ServiceFactory mServiceFactory;
    private CompositeSubscription compositeSubscription;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
        compositeSubscription = new CompositeSubscription();
    }
    @Override
    public void loadFlowers() {

        ServiceFactory serviceFactory = new ServiceFactory();
        FlowerService flowerService = serviceFactory.createRetrofit().create(FlowerService.class);
         Observable<List<FlowerResponse>> observable = flowerService.getFlower().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
       observable.subscribe(new Observer<List<FlowerResponse>>() {

            @Override
            public void onCompleted() {
                Log.d("LEE","onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LEE","Error" + e.getMessage());
            }

            @Override
            public void onNext(List<FlowerResponse> flowerResponses) {
                Log.d("LEE","Flower size" + flowerResponses.size());
                mainView.onFlower(flowerResponses);
            }
        });

    }
}
