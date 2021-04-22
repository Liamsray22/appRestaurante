package com.example.apprestaurante.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.apprestaurante.ActivityLogin;
import com.example.apprestaurante.DataBase.Database;
import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.client.ClientMainPage;
import com.example.apprestaurante.client.client;
import com.example.apprestaurante.databinding.ActivityAdminMainPageBinding;

public class adminMainPage extends AppCompatActivity {

    ActivityAdminMainPageBinding binding;
    Dialogs dialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.getInstance().getTipoUsuario() != "admin"){
            Intent isClient = new Intent(this, ClientMainPage.class);
            startActivity(isClient);
        }
        dialogs = new Dialogs(this);

        binding.createOrdersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createOrder = new Intent(getApplicationContext(), com.example.apprestaurante.admin.createOrder.class);
                startActivity(createOrder);
            }
        });

        binding.seeOrdersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs.mostrarDialog();
            }
        });

    }

    @Override
    public void onBackPressed() {
        dialogs.dialogBack();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                dialogs.dialogBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}