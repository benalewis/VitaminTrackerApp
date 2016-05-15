package com.benlewis.vitamintrackerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditVitamin extends AppCompatActivity {

    EditText name;
    EditText dose;
    EditText doseMetric;
    Button addButton;
    Spinner day;
    Spinner time;

    String daySpinnerString;
    String timeSpinnerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vitamin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.evName);
        dose = (EditText) findViewById(R.id.evDose);
        doseMetric = (EditText) findViewById(R.id.evDoseMetric);
        addButton = (Button) findViewById(R.id.evAddButton);

        //Day spinner code
        day = (Spinner) findViewById(R.id.evDaySpinner);
        ArrayAdapter<CharSequence> dayArrayAdapter = ArrayAdapter.createFromResource(this, R.array.dayArray, android.R.layout.simple_spinner_item);
        dayArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(dayArrayAdapter);

        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                daySpinnerString =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                daySpinnerString = "Monday";
            }
        });

        //Time spinner code
        time = (Spinner) findViewById(R.id.evTimeSpinner);
        ArrayAdapter<CharSequence> timeArrayAdapter = ArrayAdapter.createFromResource(this, R.array.timeArray, android.R.layout.simple_spinner_item);
        timeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(timeArrayAdapter);

        time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeSpinnerString = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                timeSpinnerString = "Morning";
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.vitamins.add(new Vitamin(name.getText().toString(), dose.getText().toString(),
                        doseMetric.getText().toString(), daySpinnerString, timeSpinnerString));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
