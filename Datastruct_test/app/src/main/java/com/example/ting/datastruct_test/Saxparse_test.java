package com.example.ting.datastruct_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Ting on 2016/4/30.
 */
public class Saxparse_test extends Activity implements View.OnClickListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);
        btn = (Button)findViewById(R.id.btn_3);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            Saxparse();
    }
    public void Saxparse(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(8000);
                    connection.setConnectTimeout(8000);
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        builder.append(line);
                    }
                    parse(builder.toString());
                }catch (Exception e){e.printStackTrace();}

            }
        }).start();

    }
    public void parse(String data){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            Cotent_test test = new Cotent_test();
            xmlReader.setContentHandler(test);
            xmlReader.parse(new InputSource(new StringReader(data)));
        }
        catch (Exception e){e.printStackTrace();}
        }
}
