package com.example.suneet.gitterim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class UserActivity extends AppCompatActivity {
    private static final String TAG="USERACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.e(TAG, "onCreate: "+TAG );
    }
}
