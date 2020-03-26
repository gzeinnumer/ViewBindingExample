package com.gzeinnumer.viewbindingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.gzeinnumer.viewbindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*
    android {
        viewBinding {
            enabled = true
        }
    }
    */

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.tv.setText("Bisa dikasih onclick");
    }
}
