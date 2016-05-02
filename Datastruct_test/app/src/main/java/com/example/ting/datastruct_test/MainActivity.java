package com.example.ting.datastruct_test;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView)findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient()
        {
           @Override
           public boolean shouldOverrideUrlLoading(WebView view, String url) {
           return super.shouldOverrideUrlLoading(view, url);
           }
         }
        );
        web.loadUrl("http://www.baidu.com");
    }
}
