package com.example.ting.broadcast_test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Ting on 2016/4/9.
 */
public class Second_activity extends Activity {
    private Button local;
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        local = (Button)findViewById(R.id.local);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcast");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcast");
        Local_receiver localReceiver = new Local_receiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    class Local_receiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"the message come from local",Toast.LENGTH_LONG).show();
        }
    }
}
