package com.example.ting.intent_test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ting on 2016/4/6.
 */
public class third_activity extends Activity{
    private TextView show;
    private Intent intent;
    private Button backing;
    private Button process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_third);
        ActivityCollector.addactivity(this);
        show = (TextView)findViewById(R.id.show);
        intent = getIntent();
        String str = intent.getStringExtra("Extra data");
        show.setText(str);
        Log.d("nothing", "success");
        backing = (Button)findViewById(R.id.backing);
        backing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra("Extra","hello");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        process = (Button)findViewById(R.id.process);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(third_activity.this);
                progressDialog.setTitle("this is a ProgressDialog");
                progressDialog.setMessage("loading....");
                progressDialog.setCancelable(true);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                progressDialog.show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeactivity(this);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("提示");
        dialog.setCancelable(true);
        dialog.setMessage("确定要退出么");
        dialog.setPositiveButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishall();
            }
        });
        dialog.show();
    }
}
