package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

/**
 * 过滤操作符
 */
public class FilterActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        filter();
        elementAt();
        distinct();
        skip();
        take();
        ignoreElements();
        throttleFirst();
        throttleWithTimeOut();
    }

    private void throttleWithTimeOut() {
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            for (int i = 0; i < 10; i++) {
                subscriber.onNext(i);
                int sleep = 100;
                if (i % 3 == 0) {
                    sleep = 300;
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onCompleted();
        }).throttleWithTimeout(200, TimeUnit.MILLISECONDS).subscribe(integer -> Log.d(TAG, "throttleWithTimeOut:" + integer));
    }

    private void throttleFirst() {
        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
            for (int i = 0; i < 10; i++) {
                subscriber.onNext(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onCompleted();
        }).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(integer -> Log.d(TAG, "throttleFirst:" + integer));
    }

    private void ignoreElements() {
        Observable.just(1, 2, 3, 4).ignoreElements().subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("wangshu", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("wangshu", "onError");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i("wangshu", "onNext");
            }
        });
    }

    private void take() {
        Observable.just(1, 2, 3, 4, 5, 6).take(2).subscribe(integer -> Log.d(TAG, "take:" + integer));
    }

    private void skip() {
        Observable.just(1, 2, 3, 4, 5, 6).skip(2).subscribe(integer -> Log.d(TAG, "skip:" + integer));
    }

    private void distinct() {
        Observable.just(1, 2, 2, 3, 4, 1).distinct().subscribe(integer -> Log.d(TAG, "distinct:" + integer));
    }

    private void elementAt() {
        Observable.just(1, 2, 3, 4).elementAt(2).subscribe(integer -> Log.d(TAG, "elementAt:" + integer));
    }

    private void filter() {
        Observable.just(1, 2, 3, 4).filter(integer -> integer > 2).subscribe(integer -> Log.d(TAG, "filter:" + integer));
    }
}
