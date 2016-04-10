package com.example.ting.data_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ting on 2016/4/10.
 */
public class Loaddata extends Activity {
    private Button biu;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_layout);
        show = (TextView)findViewById(R.id.show);
        biu = (Button)findViewById(R.id.biu);
        biu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = load();
                show.setText(str);
            }
        });

    }

    public String load(){
        FileInputStream file = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            file = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(file));
            String str = "";
            while ((str = reader.readLine()) != null)
              content.append(str);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
            return content.toString();
    }
}
