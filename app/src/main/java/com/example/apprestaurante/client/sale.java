package com.example.apprestaurante.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.apprestaurante.R;
import com.example.apprestaurante.databinding.ActivitySaleBinding;

public class sale extends AppCompatActivity {

    ActivitySaleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image = getIntent().getIntExtra("image", 0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");

        binding.FoodNameSale.setText(name);
        binding.FoodDescSale.setText(desc);
        binding.FoodPriceSale.setText(String.format("%d",price));
        binding.FoodImageSale.setImageResource(image);
    }
}