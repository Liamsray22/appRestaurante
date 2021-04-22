package com.example.apprestaurante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.admin.adminMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityRegistroBinding;

public class ActivityRegistro extends AppCompatActivity {
    TextView tv;
    ActivityRegistroBinding binding;
    SQLiteDatabase db;
    String nombre, telefono, correo, clave, clave2;
    Dialogs dialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialogs = new Dialogs(this);

        Database con = new Database(this, "Foods",null,1);
        db = con.getWritableDatabase();

        binding.registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = binding.EdtNombreApellido.getText().toString();
                telefono = binding.EdtTelefono.getText().toString();
                correo = binding.EdtCorreo.getText().toString();
                clave = binding.EdtClave.getText().toString();
                clave2 = binding.EdtClave2.getText().toString();
                if(con.revisarClaveyCorreo(db, clave, clave2, correo)){
                    con.CrearUsuarios(db, nombre, telefono, correo, clave, 0);
                    dialogs.Exito();
                    Intent isClient = new Intent(getApplicationContext(), ActivityLogin.class);
                    startActivity(isClient);
                }else {
                    Toast.makeText(getApplicationContext(), "Datos erroneos", Toast.LENGTH_LONG).show();
                }

            }
        });
        tv = findViewById(R.id.abs);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegistro();
            }
        });

    }
    public void openActivityRegistro(){
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

}