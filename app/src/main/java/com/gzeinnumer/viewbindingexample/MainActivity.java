package com.gzeinnumer.viewbindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.gzeinnumer.viewbindingexample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterRVMultiType.MyOnClick {

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

        spesialRecyclerView();
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

    private void spesialRecyclerView() {
        AdapterRV adapterData = new AdapterRV();
        adapterData.setOnClick(new AdapterRV.MyOnClick() {
            @Override
            public void myOnClick(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

        AdapterRVMultiType adapterMT = new AdapterRVMultiType();
        adapterMT.setOnClick(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("RV 1");
        list.add("RV 2");
        binding.rv.setAdapter(adapterMT);
        adapterMT.setList(list);
        binding.rv.hasFixedSize();
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void myOnClick(int position) {
        Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}
