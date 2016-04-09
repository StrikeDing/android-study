package com.example.ting.custom_control;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ting on 2016/4/8.
 */
public class Title_layout extends LinearLayout{
    private Button back;
    private Button edit;
    private TextView text;
    public Title_layout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        text = (TextView)findViewById(R.id.text);
        back = (Button)findViewById(R.id.back);
        edit = (Button)findViewById(R.id.edit);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
            }
        });
        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"nothing happen",Toast.LENGTH_LONG).show();

            }
        });
    }
}
