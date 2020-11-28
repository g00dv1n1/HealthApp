package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {

    private ArrayList<StatisticsValue> userStatistics = new ArrayList<>();
    private final static String TAG = "Statistics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        final EditText weight = findViewById(R.id.userWeight);
        final EditText step = findViewById(R.id.userSteps);
        Button buttonSave = findViewById(R.id.buttonSaveStatistic);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"On click button save statistics");
                String weightStr = weight.getText().toString();
                String stepStr = step.getText().toString();

                if (weightStr.isEmpty() || stepStr.isEmpty()){
                    Toast.makeText(Statistics.this, getText(R.string.empty_message), Toast.LENGTH_SHORT).show();
                    return;
                }
                float weightFl = Float.parseFloat(weightStr);
                int stepInt = Integer.parseInt(stepStr);
                StatisticsValue userStat = new StatisticsValue(weightFl,stepInt);
                userStatistics.add(userStat);
            }
        });
    }
}