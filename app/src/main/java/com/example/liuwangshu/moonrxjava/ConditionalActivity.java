package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * 条件和布尔操作符
 */
public class ConditionalActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditional);
        all();
        contains();
        isEmpty();
        amb();
        defaultIfEmpty();
    }

    private void defaultIfEmpty() {
        Observable.create((Observable.OnSubscribe<Integer>) Observer::onCompleted).defaultIfEmpty(3).subscribe(integer -> Log.d(TAG, "defaultIfEmpty:" + integer));
    }

    private void amb() {
        Observable.amb(Observable.just(1, 2, 3).delay(2, TimeUnit.SECONDS), Observable.just(4, 5, 6)).subscribe(integer -> Log.d(TAG, "amb:" + integer));
    }

    private void isEmpty() {
        Observable.just(1, 2, 3).isEmpty().subscribe(aBoolean -> Log.d(TAG, "isEmpty:" + aBoolean));
    }

    private void contains() {
        Observable.just(1, 2, 3).contains(1).subscribe(aBoolean -> Log.d(TAG, "contains:" + aBoolean));
    }

    private void all() {
        Observable.just(1, 2, 3).all(integer -> {
            Log.d(TAG, "call:" + integer);
            return integer < 2;
        }).subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Log.d(TAG, "onNext:" + aBoolean);
            }
        });
    }
}
