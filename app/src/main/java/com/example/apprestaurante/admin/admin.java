package com.example.apprestaurante.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.apprestaurante.Adapters.FoodAdapter;
import com.example.apprestaurante.Adapters.OrderAdapter;
import com.example.apprestaurante.Models.FoodModel;
import com.example.apprestaurante.Models.OrderModel;
import com.example.apprestaurante.R;
import com.example.apprestaurante.databinding.ActivityAdminBinding;
import com.example.apprestaurante.databinding.ActivityClientBinding;

import java.util.ArrayList;

public class admin extends AppCompatActivity {

    ActivityAdminBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderModel> OrderList = new ArrayList<>();
        OrderList.add(new OrderModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));
        OrderList.add(new OrderModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));
        OrderList.add(new OrderModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));
        OrderList.add(new OrderModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));
        OrderList.add(new OrderModel("Comida", "20", "No se comia", R.drawable.ic_launcher_background));


        OrderAdapter adapter = new OrderAdapter(OrderList, this);
        binding.adminRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.adminRecyclerView.setLayoutManager(layoutManager);
    }
}