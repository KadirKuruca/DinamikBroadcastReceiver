package com.kadirkuruca.dinamikbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Kadir on 24.03.2018.
 */

public class FirstReceiver extends BroadcastReceiver {

    public static final String TAG = FirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("KADİR","Birinci Receiver");
        Toast.makeText(context,"Birinci Receiver",Toast.LENGTH_SHORT).show();
    }
}
