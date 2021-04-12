package com.example.carconfigurator.model;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;
import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.brand.Brand;
import com.example.carconfigurator.brand.Brand_Querries;
import com.example.carconfigurator.database.ConnectionException;

import java.util.ArrayList;
import java.util.List;

public class Model_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.model_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        List<Model> modelList = fillModelList();

        TextView brandNameTextView = findViewById(R.id.brandNameTextView);
        assert configuratedCar != null;
        brandNameTextView.setText(configuratedCar.getBrand().getName());

        buildRecyclerView(modelList, configuratedCar);
    }

    private List<Model> fillModelList() {
        ArrayList<Model> modelList = null;
        try {
            modelList = (ArrayList<Model>) Model_Querries.getAllData();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    private void buildRecyclerView(List<Model> modelList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.modelRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Model_Adapter adapter = new Model_Adapter((ArrayList<Model>) modelList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Model_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setModel(modelList.get(position));
            }
        });
    }
}
