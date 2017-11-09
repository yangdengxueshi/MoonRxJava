package com.example.liuwangshu.moonrxjava.bus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.liuwangshu.moonrxjava.R;

public class RxBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);

        findViewById(R.id.bt_post).setOnClickListener(v -> RxBus.getInstance().post(new MessageEvent("用RxJava实现RxBus")));
    }
}
