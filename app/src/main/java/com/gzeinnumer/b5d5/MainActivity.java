package com.gzeinnumer.b5d5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.gzeinnumer.b5d5.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRV();
    }

    private ArrayList<MyModel> list = new ArrayList<>();
    private RvAdapter adapter;

    private void initRV() {
        for (int i = 0; i < 100; i++) {
            list.add(new MyModel(i, "Zein "+i));
        }

        adapter = new RvAdapter();
        adapter.setList(list);

        binding.rvData.setAdapter(adapter);
        binding.rvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        binding.rvData.setHasFixedSize(true);
        binding.rvData.hasFixedSize();

        binding.edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(editable.toString());
            }
        });
    }
}