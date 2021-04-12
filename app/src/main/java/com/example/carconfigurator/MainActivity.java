package com.example.carconfigurator;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.carconfigurator.database.Connector;
import com.example.carconfigurator.database.TestQuerries;
import com.example.carconfigurator.inProgress.Brand_Activity;
import com.example.carconfigurator.testSpinner.SpinnerAdapter;
import com.example.carconfigurator.testSpinner.SpinnerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private SpinnerAdapter spinnerAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createOnClickEvent();
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.textView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        textView.setText(Connector.connectToTestDatabase());
    }

    private void createOnClickEvent() {
        Button fucker = findViewById(R.id.goToStartpageBtn);
        fucker.setOnClickListener(v -> {
            Intent startpage_Activity = new Intent(getApplicationContext(), Brand_Activity.class);
            startpage_Activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if(startpage_Activity != null) {
                Toast.makeText(this, "Si", Toast.LENGTH_SHORT).show();
                startActivity(startpage_Activity);
            }else{
                Toast.makeText(this, "Nope", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void sqlButton(View view){
        fillSpinner((ArrayList<SpinnerItem>) TestQuerries.getTestData(), R.id.spinner);
    }

    private void fillSpinner(ArrayList<SpinnerItem> spinnerList, int spinnerID){
        Spinner spinner = (Spinner) findViewById(spinnerID);
        spinnerAdapter = new SpinnerAdapter(this, spinnerList);
        // Create an ArrayAdapter using the string array and a default spinner layout
        // ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this,
        //         android.R.layout.simple_spinner_item, array);
        // Specify the layout to use when the list of choices appears
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerItem clickedItem = (SpinnerItem) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "You clicked on " + clickedItem.getTestName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}