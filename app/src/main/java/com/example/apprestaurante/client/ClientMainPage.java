package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                Intent seeAll = new Intent(getApplicationContext(), client.class);
                startActivity(seeAll);
            }
        });

    }
    @Override
    public void onBackPressed() {
        dialogs.dialogBack();
    }
}