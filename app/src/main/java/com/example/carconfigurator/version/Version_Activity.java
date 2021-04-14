package com.example.carconfigurator.version;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.R;
import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.engine.Engine_Activity;

import java.util.ArrayList;
import java.util.List;

public class Version_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.version_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        List<Version> versionList = fillVersionList(configuratedCar);

        TextView brandVersionNameTextView = findViewById(R.id.brandVersionNameTextView);
        assert configuratedCar != null;
        brandVersionNameTextView.setText(configuratedCar.getBrand().getName()
                                        + " - "
                                        + configuratedCar.getModel().getName());

        buildRecyclerView(versionList, configuratedCar);
    }

    private List<Version> fillVersionList(ConfiguratedCar configuratedCar) {
        ArrayList<Version> versionList = null;
        try {
            versionList = (ArrayList<Version>) Version_Querries.getAllDataFromModel(configuratedCar.getBrand().getId()
                                                                                    ,configuratedCar.getModel().getId());
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return versionList;
    }

    private void buildRecyclerView(List<Version> versionList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.versionRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Version_Adapter adapter = new Version_Adapter((ArrayList<Version>) versionList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Version_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setVersion(versionList.get(position));
                Intent intent = new Intent(Version_Activity.this, Engine_Activity.class);
                intent.putExtra("configuratedCar", configuratedCar);
                startActivity(intent);
            }
        });
    }
}
