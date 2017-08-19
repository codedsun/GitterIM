package com.example.suneet.gitterim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String TAG="MainActivity";
    //public static final String URL="https://gitter.im/login/oauth/authorize?client_id=6ed58fd00e49db1aa862a91276be30b4c7936fd2&response_type=code&redirect_uri=http://about:blank";
    Button btnLogin,btnSignUp;
    SharedPreferences sharedPreferences;
    String accessToken="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getPreferences(MODE_PRIVATE);
        accessToken=sharedPreferences.getString("token","");


        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accessToken.isEmpty())
                {
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();

                }
                else
                    startActivity(new Intent(MainActivity.this,UserActivity.class));
                    finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yet to Be Implemented", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
