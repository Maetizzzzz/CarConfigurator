package com.example.carconfigurator.brand;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.InternalStorage;
import com.example.carconfigurator.R;
import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.model.Model_Activity;
import com.example.carconfigurator.summary.Summary_Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Brand_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Brand_Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.brand_activity);

        Connector.connectToCarConfiguratorDatabase();
        ConfiguratedCar configuratedCar = new ConfiguratedCar();
        List<Brand> brandList = fillBrandList();
        buildBrandRecyclerView(brandList, configuratedCar);

        try {
            buildConfiguredCarRecyclerView(readConfiguredCard());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "ID Brand: " +brandList.get(0).getId(),Toast.LENGTH_LONG).show();
    }

    private List<ConfiguratedCar> readConfiguredCard() throws IOException, ClassNotFoundException {
        return (List<ConfiguratedCar>) InternalStorage.readObject(this, "ConfiguredCars");
    }

    private List<Brand> fillBrandList() {
        ArrayList<Brand> brandList = null;
        try {
            brandList = (ArrayList<Brand>) Brand_Querries.getAllData();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return brandList;
    }

    private void buildBrandRecyclerView(List<Brand> brandList, ConfiguratedCar configuratedCar) {
        recyclerView = findViewById(R.id.brandRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Brand_Adapter((ArrayList) brandList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Brand_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setBrand(brandList.get(position));
                Intent intent = new Intent(Brand_Activity.this, Model_Activity.class);
                intent.putExtra("configuratedCar", configuratedCar);
                startActivity(intent);
            }
        });
    }

    private void buildConfiguredCarRecyclerView(List<ConfiguratedCar> configuratedCarsList) {
        RecyclerView recyclerView = findViewById(R.id.configuredCarsRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Configured_Car_Adapter adapter = new Configured_Car_Adapter((ArrayList) configuratedCarsList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Configured_Car_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(Brand_Activity.this, Summary_Activity.class);
                intent.putExtra("configuratedCar", configuratedCarsList.get(position));
                startActivity(intent);
            }
        });
    }
}
