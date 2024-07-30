package com.ahmet.androiduitestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

import com.ahmet.androiduitestapp.topbar.TopBarActivity;

public class MainActivity extends AppCompatActivity {
    private SteeringGuidelineView steeringGuidelineView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        steeringGuidelineView = findViewById(R.id.guidelineOverlayView);
        seekBar = findViewById(R.id.seekBar);


        Intent intent = new Intent(MainActivity.this, TopBarActivity.class);
        startActivity(intent);
        // Set a listener for the seek bar to update the steering angle
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float steeringAngle = (progress - 50) * 2; // Convert progress to steering angle (-100 to 100)
                steeringGuidelineView.setSteeringAngle(steeringAngle);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for this example
            }
        });
    }
}