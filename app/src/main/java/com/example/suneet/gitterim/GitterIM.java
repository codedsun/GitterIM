package com.example.suneet.gitterim;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsIntent;
import android.util.Log;
import android.view.View;

import okhttp3.OkHttpClient;

/**
 * Created by suneet on 12/8/17.
 */

public class GitterIM  {
    public static final String TAG="DO";
    public static String redirectURL;
    public static String client_id;
    public static String response_type="code";
    public static String BASE_URL="https://gitter.im/login/oauth/authorize?q=";
    public static  String COMPLETE_URL="";
    public OkHttpClient okHttpClient;
    private static CustomTabsIntent customTabsIntent;
    private static CustomTabsIntent.Builder builder;
    private static CustomTabsCallback customTabsCallback;
    public static Uri Url;



    public static void initialize(String redirectURL,String client_id)
    {
        GitterIM.redirectURL = redirectURL;
        GitterIM.client_id=client_id;
        COMPLETE_URL=BASE_URL+client_id+"&"+response_type+"&"+redirectURL;
        Log.e(TAG, "initialize: "+COMPLETE_URL );
    }

    public static String getRedirectURL() {
        return redirectURL;
    }

    public static String getClient_id() {
        return client_id;
    }

    public  static void login(Activity activity) {
        builder=new CustomTabsIntent.Builder();
        customTabsIntent=builder.build();
        Url.parse(COMPLETE_URL);
        customTabsIntent.launchUrl(activity,Url);


    }
}
