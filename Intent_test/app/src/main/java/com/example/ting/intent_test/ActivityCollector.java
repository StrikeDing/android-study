package com.example.ting.intent_test;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ting on 2016/4/8.
 */
public class ActivityCollector {
    public static List<Activity> activitys = new ArrayList<Activity>();
    public static void addactivity(Activity activity){
      activitys.add(activity);
    }
    public  static void removeactivity(Activity activity){
      activitys.remove(activity);
    }
    public static void finishall(){
        for(Activity activity : activitys)
            if(!activity.isFinishing())
                activity.finish();
    }
}
