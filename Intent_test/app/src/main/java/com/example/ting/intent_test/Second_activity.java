package com.example.ting.intent_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Ting on 2016/4/6.
 */
public class Second_activity extends Activity {

    private Button bt2;
    private Intent it;
    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        ActivityCollector.addactivity(this);
        bt2 = (Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new Intent(Second_activity.this,MainActivity.class);
                startActivity(it);
            }
        });
        bt3 = (Button)findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new Intent("com.example.ting.first");
                startActivity(it);
            }
        });
    }

    @Override
    public void onBackPressed() {
        it = new Intent();
        it.putExtra("Extra","I am second activity");
        setResult(RESULT_OK,it);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeactivity(this);
    }
}
