package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 组合操作符
 */
public class CombineActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine);
        startWith();
        merge();
        concat();
        zip();
        combineLastest();
    }

    private void combineLastest() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3);
        Observable<String> obs2 = Observable.just("a", "b", "c");
        Observable.combineLatest(obs1, obs2, (integer, s) -> integer + s).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "combineLastest:" + s);
            }
        });
    }

    private void zip() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3);
        Observable<String> obs2 = Observable.just("a", "b", "c");
        Observable.zip(obs1, obs2, (integer, s) -> integer + s).subscribe(s -> Log.d(TAG, "zip:" + s));
    }

    private void concat() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> obs2 = Observable.just(4, 5, 6);
        Observable.concat(obs1, obs2).subscribe(integer -> Log.d(TAG, "concat:" + integer));
    }

    private void merge() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> obs2 = Observable.just(4, 5, 6);
        Observable.merge(obs1, obs2).subscribe(integer -> Log.d(TAG, "merge:" + integer));
    }

    private void startWith() {
        Observable.just(3, 4, 5).startWith(1, 2).subscribe(integer -> Log.d(TAG, "startWith:" + integer));
    }
}
