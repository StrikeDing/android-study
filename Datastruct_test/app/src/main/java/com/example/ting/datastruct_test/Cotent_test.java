package com.example.ting.datastruct_test;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Ting on 2016/4/30.
 */
public class Cotent_test extends DefaultHandler {
    private String nodename;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        nodename = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if("id".equals(nodename)){ id.append(ch,start,length);}
        else  if("name".equals(nodename)){name.append(ch,start,length);}
        else if ("version".equals(nodename)){version.append(ch,start,length);}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("app".equals(nodename)){
            Log.d("content","id is "+id.toString().trim());
            Log.d("content","name is "+name.toString().trim());
            Log.d("content","version is "+version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
