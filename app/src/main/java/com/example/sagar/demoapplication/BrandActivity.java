package com.example.sagar.demoapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class BrandActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 5000;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_brand);

//        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font/ralewayBold.ttf");
//        appName = (TextView) findViewById(R.id.appName);
//        appName.setTypeface(typeface);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                SharedPreferences sharedPref = getSharedPreferences("userState", Context.MODE_PRIVATE);
//                String state = sharedPref.getString("isLoggedIn", "false");
//                Toast.makeText(InitialIntroActivity.this,state,Toast.LENGTH_LONG).show();
//                if(state.equals("true")) {
                    Intent i = new Intent(BrandActivity.this, OrderActivity.class);
                    startActivity(i);
//                }
//                else{
//                    Intent i = new Intent(BrandActivity.this, LoginActivity.class);
//                    startActivity(i);
//                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
