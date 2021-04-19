package com.example.apprestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apprestaurante.ActivityRegistro;
import com.example.apprestaurante.R;

public class ActivityLogin extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv = findViewById(R.id.texto);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegistro();
            }
        });



        }
    public void openActivityRegistro(){
        Intent intent = new Intent(this, ActivityRegistro.class);
        startActivity(intent);
    }
}