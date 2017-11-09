package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * 变换操作符
 */
public class TransformActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        map();
        flatMap();
        concatMap();
        flatMapIterable();
        buffer();
        groupBy();
    }

    private void groupBy() {
        Swordsman s1 = new Swordsman("韦一笑", "A");
        Swordsman s2 = new Swordsman("张三丰", "SS");
        Swordsman s3 = new Swordsman("周芷若", "S");
        Swordsman s4 = new Swordsman("宋远桥", "S");
        Swordsman s5 = new Swordsman("殷梨亭", "A");
        Swordsman s6 = new Swordsman("张无忌", "SS");
        Swordsman s7 = new Swordsman("鹤笔翁", "S");
        Swordsman s8 = new Swordsman("宋青书", "A");

        Observable<GroupedObservable<String, Swordsman>> GroupedObservable = Observable.just(s1, s2, s3, s4, s5, s6, s7, s8).groupBy(Swordsman::getLevel);
        Observable.concat(GroupedObservable).subscribe(swordsman -> Log.d(TAG, "groupBy:" + swordsman.getName() + "---" + swordsman.getLevel()));
    }

    private void buffer() {
        Observable.just(1, 2, 3, 4, 5, 6).buffer(3).subscribe(integers -> {
            for (Integer i : integers) {
                Log.d(TAG, "buffer:" + i);
            }
            Log.d(TAG, "-----------------");
        });
    }

    private void flatMapIterable() {
        Observable.just(1, 2, 3).flatMapIterable(s -> {
            List<Integer> mlist = new ArrayList<>();
            mlist.add(s + 1);
            return mlist;
        }).subscribe(integer -> Log.d(TAG, "flatMapIterable:" + integer));
    }

    private void concatMap() {
        final String Host = "http://blog.csdn.net/";
        List<String> mlist = new ArrayList<>();
        mlist.add("itachi85");
        mlist.add("itachi86");
        mlist.add("itachi87");
        mlist.add("itachi88");
        Observable.from(mlist).concatMap((Func1<String, Observable<?>>) s -> Observable.just(Host + s)).cast(String.class).subscribe(s -> Log.d(TAG, "concatMap:" + s));
    }

    private void flatMap() {
        final String Host = "http://blog.csdn.net/";
        List<String> mlist = new ArrayList<>();
        mlist.add("itachi85");
        mlist.add("itachi86");
        mlist.add("itachi87");
        mlist.add("itachi88");
        Observable.from(mlist).flatMap((Func1<String, Observable<?>>) s -> Observable.just(Host + s)).cast(String.class).subscribe(s -> Log.d(TAG, "flatMap:" + s));
    }

    private void map() {
        final String Host = "http://blog.csdn.net/";
        Observable.just("itachi85").map(s -> Host + s).subscribe(s -> Log.d(TAG, "map:" + s));
    }
}
