package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.example.apprestaurante.Adapters.FoodAdapter;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.databinding.ActivityClientBinding;
import com.example.apprestaurante.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class client extends AppCompatActivity {

    ActivityClientBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<FoodModel> FoodList = new ArrayList<>();
        FoodList.add(new FoodModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));
        FoodList.add(new FoodModel("Food", "20", "No se caslk", R.mipmap.ic_launcher_round));
        FoodList.add(new FoodModel("Nose", "20", "sdjkfhskdf", R.drawable.ic_launcher_background));
        FoodList.add(new FoodModel("Algo", "20", "cackokjsdh", R.drawable.ic_launcher_background));
        FoodList.add(new FoodModel("Pupa", "20", "Con el", R.mipmap.ic_launcher_round));

        FoodAdapter adapter = new FoodAdapter(FoodList, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}