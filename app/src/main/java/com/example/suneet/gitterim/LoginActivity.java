package com.example.suneet.gitterim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    public static final String BASE_URL="https://gitter.im/login/oauth/authorize?";
    OkHttpClient okHttpClient=new OkHttpClient();

    private final String TAG="LOGIN";
    WebView webview;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String url=BASE_URL+"client_id="+AUTHKEYS.CLIENT_ID+"&response_type="+"code"+"&"+"redirect_uri="+AUTHKEYS.REDIRECT_LINK;
        Log.e(TAG, "onCreate: "+url );
        webview= (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);


        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient(){


            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                webview.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if(url.contains(AUTHKEYS.REDIRECT_LINK )&& url.contains("?code="))
                {
                    String code=url.substring((url.indexOf('=')+1),url.length());
                    Toast.makeText(LoginActivity.this, ""+code, Toast.LENGTH_SHORT).show();
                    RequestBody requestBody=new FormBody.Builder().add("client_id",AUTHKEYS.CLIENT_ID)
                            .add("client_secret",AUTHKEYS.CLIENT_SECRET)
                            .add("code",code)
                            .add("redirect_uri",AUTHKEYS.REDIRECT_LINK)
                            .add("grant_type","authorization_code")
                            .build();
                    Request request=new Request.Builder().url("https://gitter.im/login/oauth/token")
                            .method("POST",requestBody)
                            .addHeader("Accept","application/json")
                            .post(requestBody).build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responsecode=response.body().string();
                            try {
                                JSONObject jsonObject=new JSONObject(responsecode);
                                final String token=jsonObject.getString("access_token");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, ""+token, Toast.LENGTH_SHORT).show();
                                        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("PROFILE",0);
                                        sharedPreferences.edit().putString("token",token).apply();
                                        AUTHKEYS.setTOKEN(token);
                                        Intent i=new Intent(LoginActivity.this,UserActivity.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    return true;
                }
                else {
                    return false;
                }

            }

        });
        webview.loadUrl(url);




    }

}
