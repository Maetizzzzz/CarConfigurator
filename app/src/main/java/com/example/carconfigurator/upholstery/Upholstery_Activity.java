package com.example.carconfigurator.upholstery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.MainActivity;
import com.example.carconfigurator.R;
import com.example.carconfigurator.colour.Colour_Activity;
import com.example.carconfigurator.database.ConnectionException;

import java.util.ArrayList;
import java.util.List;

public class Upholstery_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.upholstery_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        List<Upholstery> upholsteryList = fillUpholsteryList(configuratedCar);

        TextView brandVersionNameTextView = findViewById(R.id.brandVersionNameTextView);
        assert configuratedCar != null;
        brandVersionNameTextView.setText(configuratedCar.getBrand().getName()
                                        + " - "
                                        + configuratedCar.getModel().getName());

        buildRecyclerView(upholsteryList, configuratedCar);
        Toast.makeText(this, configuratedCar.getVersion().toString(), Toast.LENGTH_LONG).show();
    }

    private List<Upholstery> fillUpholsteryList(ConfiguratedCar configuratedCar) {
        ArrayList<Upholstery> upholsteryList = null;
        try {
            upholsteryList = (ArrayList<Upholstery>) Upholstery_Querries.getAllUpholsteriesForVersion(configuratedCar.getVersion().getId());
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return upholsteryList;
    }

    private void buildRecyclerView(List<Upholstery> upholsteryList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.upholsteryRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Upholstery_Adapter adapter = new Upholstery_Adapter((ArrayList<Upholstery>) upholsteryList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Upholstery_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setUpholstery(upholsteryList.get(position));
                Intent intent = new Intent(Upholstery_Activity.this, MainActivity.class);
                intent.putExtra("configuratedCar", configuratedCar);
                startActivity(intent);
            }
        });
    }
}
