package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = findViewById(R.id.userName);
        final EditText userAge = findViewById(R.id.userAge);
        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = userName.getText().toString();
                String ageStr = userAge.getText().toString();

                if (nameStr.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, getText(R.string.empty_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                int age = Integer.parseInt(ageStr);
                User user = new User(nameStr,age);
                users.add(user);
            }
        });

        Button buttonPressure = findViewById(R.id.buttonPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPressure = new Intent(MainActivity.this,Pressure.class);
                startActivity(intentPressure);
            }
        });

        Button buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStatistics = new Intent(MainActivity.this,Statistics.class);
                startActivity(intentStatistics);
            }
        });
    }
}