package com.example.suneet.gitterim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static String TAG="MainActivity";
    //public static final String URL="https://gitter.im/login/oauth/authorize?client_id=6ed58fd00e49db1aa862a91276be30b4c7936fd2&response_type=code&redirect_uri=http://about:blank";
    Button btnLogin,btnSignUp;
    public String callback_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);
        callback_code=getSharedPreferences("gitter",MODE_PRIVATE).getString("code","");

      /*  if(!(callback_code.isEmpty()))
        {

            Intent i=new Intent();
            startActivity(i);
        }*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GitterIM.login(MainActivity.this);
            }
        });
    }
}
