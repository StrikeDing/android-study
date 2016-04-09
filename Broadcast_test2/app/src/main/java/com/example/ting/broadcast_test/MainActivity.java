package com.example.ting.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private broadcast broadcastchange;
    private Button send;
    private Intent intent;
    private Button order;
    private Button jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        broadcastchange = new broadcast();
        registerReceiver(broadcastchange, intentFilter);
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction("com.example.ting.test");
                sendBroadcast(intent);
            }
        });
        order = (Button)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction("com.example.ting.test");

                sendOrderedBroadcast(intent, null);
            }
        });
        jump = (Button)findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Second_activity.class);
                startActivity(intent);
            }
        });
    }
    class broadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager con =  (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo info = con.getActiveNetworkInfo();
            if(info!=null && info.isAvailable()) Toast.makeText(context,"Network is available",Toast.LENGTH_LONG);
            else Toast.makeText(context,"Network is not available",Toast.LENGTH_LONG).show();
        }




    }
}
