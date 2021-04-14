package com.example.carconfigurator.engine;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.R;
import com.example.carconfigurator.database.ConnectionException;

import java.util.ArrayList;
import java.util.List;

public class Engine_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.engine_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        List<Engine> engineList = fillEngineList(configuratedCar);

        TextView brandVersionNameTextView = findViewById(R.id.brandVersionNameTextView);
        assert configuratedCar != null;
        brandVersionNameTextView.setText(configuratedCar.getBrand().getName()
                                        + " - "
                                        + configuratedCar.getModel().getName());

        buildRecyclerView(engineList, configuratedCar);
        Toast.makeText(this, configuratedCar.getVersion().toString(), Toast.LENGTH_LONG).show();
    }

    private List<Engine> fillEngineList(ConfiguratedCar configuratedCar) {
        ArrayList<Engine> engineList = null;
        try {
            engineList = (ArrayList<Engine>) Engine_Querries.getAllEnginesForVersion(configuratedCar.getVersion().getId());
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return engineList;
    }

    private void buildRecyclerView(List<Engine> engineList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.engineRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Engine_Adapter adapter = new Engine_Adapter((ArrayList<Engine>) engineList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Engine_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setEngine(engineList.get(position));
            }
        });
    }
}
