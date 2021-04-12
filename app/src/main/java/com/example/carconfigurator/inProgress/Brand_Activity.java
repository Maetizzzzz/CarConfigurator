package com.example.carconfigurator.inProgress;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Brand_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Brand_Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.brand_activity);

        ConfiguratedCar configuratedCar = new ConfiguratedCar();
        ArrayList<Brand> brandList = fillBrandList();
        buildRecyclerView(brandList, configuratedCar);
    }

    private ArrayList<Brand> fillBrandList() {
        ArrayList<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand(R.drawable.ic_car, "Auto Brumm Brumm"));
        brandList.add(new Brand(R.drawable.ic_car, "Auto Brumm"));
        brandList.add(new Brand(R.drawable.ic_car, "Auto"));
        return brandList;
    }

    private void buildRecyclerView(ArrayList<Brand> brandList, ConfiguratedCar configuratedCar) {
        recyclerView = findViewById(R.id.brandRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Brand_Adapter(brandList);

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
}
