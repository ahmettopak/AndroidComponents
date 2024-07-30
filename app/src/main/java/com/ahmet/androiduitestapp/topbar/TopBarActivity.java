package com.ahmet.androiduitestapp.topbar;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ahmet.androiduitestapp.R;
import com.ahmet.androiduitestapp.databinding.ActivityTopBarBinding;

public class TopBarActivity extends AppCompatActivity {

    ActivityTopBarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTopBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TopBarController topBarController = new TopBarController(binding.topBar);
    }
}