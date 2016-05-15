package com.benlewis.vitamintrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner daySpinner;
    String whichDay = "Monday";

    static ArrayList<Vitamin> vitamins = new ArrayList<Vitamin>();
    static ArrayList<String> vitaminList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.mainListView);
        daySpinner = (Spinner) findViewById(R.id.mainDaySpinner);

        final ArrayAdapter<String> vitaminArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, vitaminList);

        listView.setAdapter(vitaminArrayAdapter);

        //Day spinner code
        daySpinner = (Spinner) findViewById(R.id.mainDaySpinner);
        ArrayAdapter<CharSequence> dsAdapter = ArrayAdapter.createFromResource(this, R.array.dayArray, android.R.layout.simple_spinner_item);
        dsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dsAdapter);

        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                whichDay = parent.getItemAtPosition(position).toString();
                showVitamins();
                vitaminArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        showVitamins();
        vitaminArrayAdapter.notifyDataSetChanged();
    }

    public void showVitamins() {

        vitaminList.clear();

        for (int i = 0; i < vitamins.size(); i++) {
            if (vitamins.get(i).getDay().equals(whichDay)) {
                vitaminList.add(vitamins.get(i).printVitamin());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.editVitamin) {

            Intent i = new Intent(getApplicationContext(), EditVitamin.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addVitamin(Vitamin vitamin) {

    }
}
