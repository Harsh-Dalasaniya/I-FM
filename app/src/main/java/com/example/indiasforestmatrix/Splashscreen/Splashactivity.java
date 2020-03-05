package com.example.indiasforestmatrix.Splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.indiasforestmatrix.Login.Loginactivity;
import com.example.indiasforestmatrix.R;

public class Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splashactivity.this, Loginactivity.class);
                startActivity(i);
                finish();
            }
        },4000);
    }
}
