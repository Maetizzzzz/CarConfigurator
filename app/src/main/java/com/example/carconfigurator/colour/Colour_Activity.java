package com.example.carconfigurator.colour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.R;
import com.example.carconfigurator.database.ConnectionException;
import com.example.carconfigurator.engine.Engine_Activity;
import com.example.carconfigurator.upholstery.Upholstery;
import com.example.carconfigurator.upholstery.Upholstery_Activity;

import java.util.ArrayList;
import java.util.List;

public class Colour_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.colour_activity);

        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");

        List<Colour> colourList = fillColourList(configuratedCar);

        TextView brandVersionNameTextView = findViewById(R.id.brandVersionNameTextView);
        assert configuratedCar != null;
        brandVersionNameTextView.setText(configuratedCar.getBrand().getName()
                                        + " - "
                                        + configuratedCar.getModel().getName());

        buildRecyclerView(colourList, configuratedCar);
        Toast.makeText(this, configuratedCar.getVersion().toString(), Toast.LENGTH_LONG).show();
    }

    private List<Colour> fillColourList(ConfiguratedCar configuratedCar) {
        ArrayList<Colour> colourList = null;
        try {
            colourList = (ArrayList<Colour>) Colour_Querries.getAllColoursForBrand(configuratedCar.getVersion().getId());
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return colourList;
    }

    private void buildRecyclerView(List<Colour> colourList, ConfiguratedCar configuratedCar) {
        RecyclerView recyclerView = findViewById(R.id.colourRecyclerView);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        Colour_Adapter adapter = new Colour_Adapter((ArrayList<Colour>) colourList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Colour_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                configuratedCar.setColour(colourList.get(position));
                Intent intent = new Intent(Colour_Activity.this, Upholstery_Activity.class);
                intent.putExtra("configuratedCar", configuratedCar);
                startActivity(intent);
            }
        });
    }
}
