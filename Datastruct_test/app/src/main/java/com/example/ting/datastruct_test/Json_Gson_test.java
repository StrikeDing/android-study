package com.example.ting.datastruct_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Ting on 2016/4/30.
 */
public class Json_Gson_test extends Activity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private StringBuilder content = null;
    private String line = null;
    protected int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);
        btn1 = (Button)findViewById(R.id.btn_4);
        btn2 = (Button)findViewById(R.id.btn_5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        connect(v);
    }
    public void connect(View v){
        id = v.getId();
        Thread con = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try{
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        content.append(line);
                    }
                    switch (id)
                    {
                        case R.id.btn_4:
                            parsewithJson(content.toString());
                            break;
                        case R.id.btn_5:
                            parsewithGson(content.toString());
                            break;
                    }

                }catch (Exception e){e.printStackTrace();}



            }
        });
        con.start();

    }

    private void parsewithJson(String data){
        try {
            JSONArray array = new JSONArray(data);
            for (int i = 0;i < array.length();i++){
                JSONObject object = array.getJSONObject(i);
                String id = object.getString("id");
                String name = object.getString("name");
                String version = object.getString("version");
                Log.d("id","id is "+id);
                Log.d("name","name is "+name);
                Log.d("version","version is "+version);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void parsewithGson(String data){
        Gson gson = new Gson();
        List<app_test> applist = gson.fromJson(data,new TypeToken<List<app_test>>(){}.getType());
        for (app_test app : applist)
        {
            Log.d("G_id","id is " + app.getId());
            Log.d("G_name","name is " + app.getName());
            Log.d("G_version","version is " + app.getVersion());
        }

    }
}
