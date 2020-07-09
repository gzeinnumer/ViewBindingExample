package com.gzeinnumer.viewbindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.gzeinnumer.viewbindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*
    android {
        untuk android versi di bawah 4
        viewBinding {
            enabled = true
        }

        untuk android versi 4 -> gradel versi 6.1.1 -> android gradle plugin version 4.0.0
        buildFeatures{
            viewBinding = true
        }
    }
    */

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();
    }

    private void initView() {
        binding.btn.setText("Click To Open Dialog");
    }

    private void initOnClick() {
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment previous = getSupportFragmentManager().findFragmentByTag(MainDialog.TAG);
                if(previous != null){
                    transaction.remove(previous);
                }
                DialogFragment dialog = MainDialog.newInstance();
                dialog.show(transaction,MainDialog.TAG);
            }
        });
    }
}
