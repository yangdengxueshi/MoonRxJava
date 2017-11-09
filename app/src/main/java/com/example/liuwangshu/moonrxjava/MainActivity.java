package com.example.liuwangshu.moonrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liuwangshu.moonrxjava.bus.RxBusActivity;
import com.example.liuwangshu.moonrxjava.net.OkhttpActivity;
import com.example.liuwangshu.moonrxjava.net.RetrofitActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_filter).setOnClickListener(this);
        findViewById(R.id.bt_create).setOnClickListener(this);
        findViewById(R.id.bt_conversion).setOnClickListener(this);
        findViewById(R.id.bt_combine).setOnClickListener(this);
        findViewById(R.id.bt_utility).setOnClickListener(this);
        findViewById(R.id.bt_error).setOnClickListener(this);
        findViewById(R.id.bt_conditional).setOnClickListener(this);
        findViewById(R.id.bt_okhttp).setOnClickListener(this);
        findViewById(R.id.bt_retrofit).setOnClickListener(this);
        findViewById(R.id.bt_rxbus).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_create:
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_transform:
                Intent transformIntent = new Intent(MainActivity.this, TransformActivity.class);
                startActivity(transformIntent);
                break;
            case R.id.bt_filter:
                Intent filterIntent = new Intent(MainActivity.this, FilterActivity.class);
                startActivity(filterIntent);
                break;
            case R.id.bt_combine:
                Intent combineIntent = new Intent(MainActivity.this, CombineActivity.class);
                startActivity(combineIntent);
                break;
            case R.id.bt_utility:
                Intent utilityIntent = new Intent(MainActivity.this, UtilityActivity.class);
                startActivity(utilityIntent);
                break;
            case R.id.bt_error:
                Intent errorIntent = new Intent(MainActivity.this, ErrorActivity.class);
                startActivity(errorIntent);
                break;
            case R.id.bt_conditional:
                Intent conditionalIntent = new Intent(MainActivity.this, ConditionalActivity.class);
                startActivity(conditionalIntent);
                break;
            case R.id.bt_conversion:
                Intent conversionIntent = new Intent(MainActivity.this, ConversionActivity.class);
                startActivity(conversionIntent);
                break;
            case R.id.bt_okhttp:
                Intent okhttpIntent = new Intent(MainActivity.this, OkhttpActivity.class);
                startActivity(okhttpIntent);
                break;
            case R.id.bt_retrofit:
                Intent retrofitIntent = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(retrofitIntent);
                break;
            case R.id.bt_rxbus:
                Intent rxbusIntent = new Intent(MainActivity.this, RxBusActivity.class);
                startActivity(rxbusIntent);
                break;
        }
    }
}
