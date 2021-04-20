package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.apprestaurante.R;
import com.example.apprestaurante.Utils.Dialogs;
import com.example.apprestaurante.Utils.Utils;
import com.example.apprestaurante.admin.adminMainPage;
import com.example.apprestaurante.databinding.ActivityAdminMainPageBinding;
import com.example.apprestaurante.databinding.ActivityClientMainPageBinding;

public class ClientMainPage extends AppCompatActivity {

    ActivityClientMainPageBinding binding;
    Dialogs dialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClientMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Utils.getInstance().getTipoUsuario() != "client"){
            Intent isAdmin = new Intent(this, adminMainPage.class);
            startActivity(isAdmin);
        }

        dialogs = new Dialogs(this);

        binding.seeAllCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeAll = new Intent(getApplicationContext(), client.class);
                startActivity(seeAll);
            }
        });

        binding.seeMyOrdersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeMyOrders = new Intent(getApplicationContext(), seeMyOrders.class);
                startActivity(seeMyOrders);
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