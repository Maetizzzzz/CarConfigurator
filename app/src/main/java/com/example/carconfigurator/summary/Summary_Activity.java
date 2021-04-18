package com.example.carconfigurator.summary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carconfigurator.ConfiguratedCar;
import com.example.carconfigurator.InternalStorage;
import com.example.carconfigurator.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Summary_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.summary_activity);
        ConfiguratedCar configuratedCar = (ConfiguratedCar) getIntent().getSerializableExtra("configuratedCar");
        createOnClickEvent(configuratedCar);


        TextView brand = findViewById(R.id.brand_summary_output);
        brand.setText(configuratedCar.getBrand().getName());

        TextView model = findViewById(R.id.model_summary_output);
        model.setText(configuratedCar.getModel().getName());

        TextView version = findViewById(R.id.version_summary_output);
        version.setText(configuratedCar.getVersion().getName());

        TextView engine = findViewById(R.id.engine_summary_output);
        engine.setText(configuratedCar.getEngine().getName());

        TextView colour = findViewById(R.id.colour_summary_output);
        colour.setText(configuratedCar.getColour().getName());

        TextView upholstery = findViewById(R.id.upholstery_summary_output);
        upholstery.setText(configuratedCar.getUpholstery().getName());
    }

    private void createOnClickEvent(ConfiguratedCar configuratedCar) {
        saveConfiguredCar(configuratedCar);
    }

    private void saveConfiguredCar(ConfiguratedCar configuratedCar) {
        Button saveConfiguredCar = findViewById(R.id.save_ConfiguredCar);
        configuratedCar.setName("leleelelel");
        List<ConfiguratedCar> configuratedCarList = readConfiguredCarsList(configuratedCar);

        if (configuratedCarList == null) {
            configuratedCarList = new ArrayList<>();
        }
        configuratedCarList.add(configuratedCar);

        List<ConfiguratedCar> finalConfiguratedCarList = configuratedCarList;
        saveConfiguredCar.setOnClickListener(v -> {
            try {
                InternalStorage.writeObject(this, "ConfiguredCars", finalConfiguratedCarList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private List<ConfiguratedCar> readConfiguredCarsList(ConfiguratedCar configuratedCar) {
        List<ConfiguratedCar> configuratedCarList = null;
        try {
            configuratedCarList = (List<ConfiguratedCar>) InternalStorage.readObject(this, "ConfiguredCars");
            configuratedCarList.add(configuratedCar);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return configuratedCarList;
        }
    }
}
