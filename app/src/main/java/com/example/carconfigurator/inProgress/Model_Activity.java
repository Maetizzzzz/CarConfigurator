package com.example.carconfigurator.inProgress;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.R;

import java.util.ArrayList;

public class Model_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.model_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        ArrayList<Model> modelList = fillModelList();

        TextView brandNameTextView = findViewById(R.id.brandNameTextView);
        assert configuratedCar != null;
        brandNameTextView.setText(configuratedCar.getBrand().getName());

        buildRecyclerView(modelList, configuratedCar);
    }

    private ArrayList<Model> fillModelList() {
        ArrayList<Model> modelList = new ArrayList<>();
        modelList.add(new Model(R.drawable.ic_car, "Model Brumm Brumm"));
        modelList.add(new Model(R.drawable.ic_car, "Model Brumm"));
        modelList.add(new Model(R.drawable.ic_car, "Model"));
        return modelList;
    }

    private void buildRecyclerView(ArrayList<Model> modelList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.modelRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Model_Adapter adapter = new Model_Adapter(modelList);

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
