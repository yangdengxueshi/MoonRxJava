package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * 创建操作符
 */
public class CreateActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        interval();
        range();
        repeat();
    }

    private void repeat() {
        Observable.range(0, 3).repeat(2).subscribe(integer -> Log.d(TAG, "repeat:" + integer));
    }

    private void range() {
        Observable.range(0, 5).subscribe(integer -> Log.d(TAG, "range:" + integer));
    }

    private void interval() {
        Observable.interval(3, TimeUnit.SECONDS).subscribe(mlong -> Log.d(TAG, "interval:" + mlong.intValue()));
    }
}
