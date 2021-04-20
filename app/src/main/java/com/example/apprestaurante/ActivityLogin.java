package com.example.apprestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apprestaurante.ActivityRegistro;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.ClientMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityClientBinding;
import com.example.apprestaurante.databinding.ActivityLoginBinding;

public class ActivityLogin extends AppCompatActivity {
    ActivityLoginBinding binding;
    String correo, clave;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
        }

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        binding.texto.setPaintFlags(binding.texto.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegistro();
            }
        });

        binding.BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = binding.EdtCorreoLogin.getText().toString();
                clave = binding.EdtClaveLogin.getText().toString();
                Cursor c = con.Login(db, correo, clave);
                if(c != null){
                    int tipoU = c.getInt(5);
                    Utils utils = Utils.getInstance();
                    if(tipoU!=0) {
                        utils.setTipoUsuario("admin");
                    }else {
                        utils.setTipoUsuario("client");
                    }
                    Intent enter = new Intent(getApplicationContext(), ClientMainPage.class);
                    startActivity(enter);
                }else {
                    binding.EdtClaveLogin.setText("");
                    binding.EdtCorreoLogin.setText("");
                }
            }
        });



        }
    public void openActivityRegistro(){
        Intent intent = new Intent(this, ActivityRegistro.class);
        startActivity(intent);
    }
}