package com.example.ting.contentprovider_test;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Ting on 2016/4/18.
 */
public class Contentprovider_test extends ContentProvider {
    public static final int Table1_dir = 0;
    public static final int Table1_item = 1;
    public static final int Table2_dir = 2;
    public static final int Table2_item = 3;
    public static UriMatcher uriMatcher;
    static {
        uriMatcher =new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.ting.contentprovider_test","table1",Table1_dir);
        uriMatcher.addURI("com.example.ting.contentprovider_test","table1/#",Table1_item);
        uriMatcher.addURI("com.example.ting.contentprovider_test","table2",Table2_dir);
        uriMatcher.addURI("com.example.ting.contentprovider_test","table2/#",Table2_item);
    }
    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case Table1_dir:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table1";
            case Table1_item:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";
            case Table2_dir:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table2";
            case Table2_item:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table2";
            default:
                break;
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public boolean onCreate() {
        getContext();
        return true;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri))
        {
            case Table1_dir:
                break;
            case Table1_item:
                break;
            case Table2_dir:
                break;
            case Table2_item:
                break;
        }
        return null;
    }
}
