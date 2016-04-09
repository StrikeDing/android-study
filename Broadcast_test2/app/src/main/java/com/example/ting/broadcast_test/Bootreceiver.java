package com.example.ting.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ting on 2016/4/9.
 */
public class Bootreceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"boot already",Toast.LENGTH_SHORT).show();
    }
}
