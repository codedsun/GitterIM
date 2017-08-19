package com.example.suneet.gitterim;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {
    public static final String BASE_URL="https://gitter.im/login/oauth/authorize?";

    private final String TAG="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String url=BASE_URL+"client_id="+AUTHKEYS.CLIENT_ID+"&response_type="+"code"+"&"+"redirect_uri="+AUTHKEYS.REDIRECT_LINK;
        Log.e(TAG, "onCreate: "+url );


    }
}
