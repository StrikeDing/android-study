package com.example.ting.datastruct_test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ting on 2016/4/24.
 */
public class httpconnection_test extends Activity{
    private static final int SHOW_response = 1;
    private Button get;
    private TextView text;
    public static class handler extends Handler{
        WeakReference<TextView> text;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case SHOW_response:
                    text.get().setText(msg.obj.toString());
            }
        }
    }
    handler hand = new handler();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.second_layout);
        get = (Button)findViewById(R.id.btn_1);
        text = (TextView)findViewById(R.id.text);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Sendrequest();
            }
        });
    }
    public void Sendrequest()
    {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        try {
                            URL url = new URL("http://www.baidu.com");
                            connection = (HttpURLConnection)url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setReadTimeout(8000);
                            connection.setConnectTimeout(8000);
                            InputStream inputStream = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                            StringBuilder response = new StringBuilder();
                            String line;
                            while ((line = reader.readLine())!=null){
                                response.append(line);
                            }
                            Message msg = Message.obtain(hand);
                            msg.what = SHOW_response;
                            msg.obj = response;
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                        try{
                        connection.setRequestMethod("POST");
                        DataOutputStream dataOutputStream= new DataOutputStream(connection.getOutputStream());
                        dataOutputStream.writeBytes("username=admin&password=123456");
                        }
                        catch (Exception e){e.printStackTrace();}
                    }
                }
        ).start();

    }
}
