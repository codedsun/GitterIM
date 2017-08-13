package com.example.suneet.gitterim;

import android.util.Log;

/**
 * Created by suneet on 12/8/17.
 */

public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("", "onCreate: HHASAS" );
        GitterIM.initialize(getResources().getString(R.string.callback),getResources().getString(R.string.oauth_key));
    }
}
