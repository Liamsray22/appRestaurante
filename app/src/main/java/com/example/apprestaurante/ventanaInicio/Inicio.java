package com.example.apprestaurante.ventanaInicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.apprestaurante.ActivityLogin;
import com.example.apprestaurante.R;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent enter = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(enter);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_out_right);
                finish();
            }
        }, 1000);
    }
}