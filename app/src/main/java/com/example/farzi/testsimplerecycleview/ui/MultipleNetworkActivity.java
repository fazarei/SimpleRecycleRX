package com.example.farzi.testsimplerecycleview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.farzi.testsimplerecycleview.GitHubEvents;
import com.example.farzi.testsimplerecycleview.GitHubUser;
import com.example.farzi.testsimplerecycleview.R;
import com.example.farzi.testsimplerecycleview.UserAndEvents;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MultipleNetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_network);

        Retrofit repo = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Observable<JsonObject> userObservable = repo
                .create(GitHubUser.class)
                .getUser("fazarei")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<JsonArray> eventsObservable = repo
                .create(GitHubEvents.class)
                .listEvents("fazarei")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<UserAndEvents> combined = Observable.zip(userObservable, eventsObservable,
                new Func2<JsonObject, JsonArray, UserAndEvents>() {
            @Override
            public UserAndEvents call(JsonObject jsonObject, JsonArray jsonElements) {
                return new UserAndEvents(jsonObject, jsonElements);
            }
        });

        combined.subscribe(new Subscriber<UserAndEvents>() {

            @Override
            public void onCompleted() {
                Log.d("LEE","On Complete");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LEE",e.getMessage());
            }

            @Override
            public void onNext(UserAndEvents o) {
                Log.d("LEE",""+o.user.toString());
                // You can access the results of the
                // two observabes via the POJO now
            }
        });
    }
}
