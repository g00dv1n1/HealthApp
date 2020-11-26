package com.example.healthapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Pressure extends AppCompatActivity {

   private ArrayList<PressureValue> pressureValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        final EditText pressureUp = findViewById(R.id.pressureUp);
        final EditText pressureDown = findViewById(R.id.pressureDown);
        final EditText pulseValue = findViewById(R.id.valuePulse);
        final SwitchCompat tachoValue = findViewById(R.id.tachoValue);
        final  EditText dimensionDate = findViewById(R.id.dimensionDate);
        final TextView tachoText = findViewById(R.id.textView3);
        final TextView dateText = findViewById(R.id.textView4);
        Button buttonSave = findViewById(R.id.buttonSavePressure);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String pressureUpStr = pressureUp.getText().toString();
                String pressureDownStr = pressureDown.getText().toString();
                String pulseStr = pulseValue.getText().toString();
                String dimensionDateStr = dimensionDate.getText().toString();
                String tachoStr;
                if (tachoValue.isChecked()){
                    tachoStr = tachoValue.getTextOn().toString();
                }
                else {
                    tachoStr = tachoValue.getTextOff().toString();
                }
                if (pressureUpStr.isEmpty() || pressureDownStr.isEmpty() || pulseStr.isEmpty() || dimensionDateStr.isEmpty()) {
                    Toast.makeText(Pressure.this, getText(R.string.empty_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                int pressureUpInt = Integer.parseInt(pressureUpStr);
                int pressureDownInt = Integer.parseInt(pressureDownStr);
                int pulseInt = Integer.parseInt(pulseStr);
                boolean tachoValueBool = Boolean.parseBoolean(tachoStr);
                Date dimensionDateDate = null;
                try {
                    dimensionDateDate = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(dimensionDateStr);
                } catch (ParseException e) {
                    Toast.makeText(Pressure.this, getText(R.string.error_message), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                PressureValue userValues = new PressureValue(pressureUpInt,pressureDownInt,pulseInt,tachoValueBool,dimensionDateDate);
                pressureValues.add(userValues);
            }
        });
    }
}