package com.example.ting.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ting on 2016/4/9.
 */
public class My_broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received form my broadcast receiver",Toast.LENGTH_LONG).show();
        abortBroadcast();
    }
}
