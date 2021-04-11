package com.example.carconfigurator.testSpinner;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

public class SpinnerItem {
    private String testName;
    private Button buttonInformation;

    public SpinnerItem(String testName, Button buttonInformation, Context context){
        this.testName = testName;
        this.buttonInformation = buttonInformation;

        buttonInformation.setOnClickListener(v-> {
            Toast.makeText(context,
                    "You clicked on " + getTestName(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    public SpinnerItem(String testName){
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public Button getButtonInformation() {
        return buttonInformation;
    }
}
