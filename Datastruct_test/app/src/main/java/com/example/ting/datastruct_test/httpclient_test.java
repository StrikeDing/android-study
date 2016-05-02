package com.example.ting.datastruct_test;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ting on 2016/4/26.
 */
public class httpclient_test extends Activity implements View.OnClickListener {
    private Button get;
    private TextView textView;
    public static class thandler extends Handler{
        WeakReference<Activity> weakReference;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity activity = weakReference.get();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        get = (Button)findViewById(R.id.btn_2);
        get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try {
                    URL url = new URL("http://10.0.2.2/get_data.xml");
                    httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setConnectTimeout(8000);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine())!=null)
                    {
                        builder.append(line);
                    }
                    parsepull(builder.toString());
                }catch (Exception e){e.printStackTrace();}


            }
        }).start();
    }
    public void parsepull(String data)
    {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(data));
            int type = 0;
            type = parser.getEventType();
            String id ="";
            String name = "";
            String year = "";
            String node = "";
            type = parser.next();
            while (type != parser.END_DOCUMENT){
                node = parser.getName();
            switch (type){
                case XmlPullParser.START_TAG:
                    if (node.equals("id")){id = parser.nextText();break;}
                    else if (node.equals("name")){name = parser.nextText();break;}
                    else if (node.equals("year")){year = parser.nextText();break;}
                    break;
                case XmlPullParser.END_TAG:
                    if(node.equals("people")){
                        Log.d("id is ",id);
                        Log.d("name is ",name);
                        Log.d("year is ",year);
                    }break;

            }
                type = parser.next();
            }
        }catch (Exception e){e.printStackTrace();}
    }
}
