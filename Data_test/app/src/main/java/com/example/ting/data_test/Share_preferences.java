package com.example.ting.data_test;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ting on 2016/4/10.
 */
public class Share_preferences extends Activity{
    private Button save;
    private Button load;
    private TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_layout);
        save = (Button)findViewById(R.id.save);
        load = (Button)findViewById(R.id.load);
        text2 = (TextView)findViewById(R.id.text2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                editor.putString("name","YunChang");
                editor.putInt("age",21);
                editor.putBoolean("married",false);
                editor.commit();
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences editor = getSharedPreferences("save",MODE_PRIVATE);
                String str = editor.getString("name","");
                int i = editor.getInt("age",0);
                boolean choice = editor.getBoolean("married",false);
                text2.setText("name:"+str+"\n"+"age:"+i+"\n"+"married:"+choice+"\n");
            }
        });
    }
}
