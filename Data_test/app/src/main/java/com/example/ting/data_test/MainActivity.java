package com.example.ting.data_test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {
    private EditText editText;
    private Button jump;
    private Intent intent;
    private Button jump2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edit);
        jump = (Button)findViewById(R.id.jump);
        jump2 = (Button)findViewById(R.id.jump2);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                save(input);
                intent = new Intent(MainActivity.this,Loaddata.class);
                startActivity(intent);
            }
        });
        jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,Share_preferences.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input = editText.getText().toString();
        save(input);
    }

    public void save(String inputdata){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputdata);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null) writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
