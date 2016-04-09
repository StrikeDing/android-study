package com.example.ting.intent_test;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Intent intent;
    private Button bt;
    private Button btw;
    private Button btp;
    private Button pass;
    private Button result;
    private TextView tx;
    private Button another;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ActivityCollector.addactivity(this);
        bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,Second_activity.class);
                startActivity(intent);

            }
        });
        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent("com.example.ting.second");
                startActivity(intent);
            }
        });
        btw = (Button)findViewById(R.id.btw);
        btw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        btp = (Button)findViewById(R.id.btp);
        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        pass = (Button)findViewById(R.id.pass);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,third_activity.class);
                intent.putExtra("Extra data","i am coming");
                startActivity(intent);
            }
        });
        result = (Button)findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, third_activity.class);
                startActivityForResult(intent, 1);
            }
        });
        another = (Button)findViewById(R.id.another);
        another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Second_activity.class);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode)
       {
           case 1:
               if(resultCode == RESULT_OK)
               {
                   tx = (TextView)findViewById(R.id.textView);
                   String str = data.getStringExtra("Extra");
                   tx.setText(str);
               }
           case  2:
               if(resultCode == RESULT_OK)
               {
                   tx = (TextView)findViewById(R.id.textView);
                   String str = data.getStringExtra("Extra");
                   tx.setText(str);
               }
       }
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
