package com.example.liuwangshu.moonrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;

/**
 * 转换操作符
 */
public class ConversionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion2);
        toList();
        toMap();
        toSortedList();
    }

    private void toSortedList() {
        Observable.just(3, 1, 2).toSortedList().subscribe(integers -> {
            for (int integer : integers) {
                Log.i("wangshu", "toSortedList:" + integer);
            }
        });
    }

    private void toMap() {
        Swordsman s1 = new Swordsman("韦一笑", "A");
        Swordsman s2 = new Swordsman("张三丰", "SS");
        Swordsman s3 = new Swordsman("周芷若", "S");
        Observable.just(s1, s2, s3).toMap(Swordsman::getLevel).subscribe(stringSwordsmanMap -> Log.i("wangshu", "toMap:" + stringSwordsmanMap.get("SS").getName()));
    }

    private void toList() {
        Observable.just(1, 2, 3).toList().subscribe(integers -> {
            for (int integer : integers) {
                Log.i("wangshu", "toList:" + integer);
            }
        });
    }
}
