package com.kadirkuruca.dinamikbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int dakika = 1;
    TextView text;
    private FirstReceiver firstReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstReceiver = new FirstReceiver();
        text = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intenFilter = new IntentFilter();
        //intenFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intenFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(firstReceiver,intenFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(firstReceiver);
    }

    public void registerReceiver(View view) {

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(myTimeTickReceiver,filter);

    }

    public void unRegisterReceiver(View view) {
        unregisterReceiver(myTimeTickReceiver);
    }

    private BroadcastReceiver myTimeTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent ıntent) {
            Log.e("KADİR","myTimeTickReceiver Başlatıldı.");
            Toast.makeText(context,"myTimeTickReceiver Başlatıldı.",Toast.LENGTH_SHORT).show();

            text.setText(dakika +" dakika geçti");
            dakika++;
        }
    };
}
