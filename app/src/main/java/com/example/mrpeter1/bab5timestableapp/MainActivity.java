package com.example.mrpeter1.bab5timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listviewji ;

    public void generateTimesTable(int timesTableNumber){

        ArrayList<String>timesTableContent = new ArrayList<String>();
        for (int j=1; j<=10; j++){

            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1, timesTableContent);
        listviewji.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listviewji = findViewById(R.id.listviewji);
        final SeekBar VolumeSeekBar = (SeekBar) findViewById(R.id.VolumeSeekBar);

        VolumeSeekBar.setMax(20); // nilai maksimal
        VolumeSeekBar.setProgress(10);

        VolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    VolumeSeekBar.setProgress(min);
                }else {
                    timesTableNumber = progress;
                }
                Log.i("seekbar log = ", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
