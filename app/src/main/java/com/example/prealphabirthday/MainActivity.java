package com.example.prealphabirthday;

import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set with layout's resource ID
        BdaysAdapter adapter = new BdaysAdapter(generateBVMList()); // Instantiate adapter
        RecyclerView bdaysView = (RecyclerView) findViewById(R.id.bdays_view);
        bdaysView.setLayoutManager(new LinearLayoutManager(this));
        bdaysView.setHasFixedSize(true);
        bdaysView.setAdapter(adapter);
    }

    private List<BdaysViewModel> generateBVMList() {
        // Create list of BdaysViewModel to pass into adapter
        List<BdaysViewModel> viewModelsList = new ArrayList<>();
        // String[] names = new String[20];
        String[] names = {"William", "Alsion", "Mom", "Dad", "Jason", "Justin", "Brik Boi", "Brik Boi", "Brik Boi", "Brik Boi", "Brik Boi", "Brik Boi", "Brik Boi"};
        for (int i = 0; i < names.length ; i++) {
            viewModelsList.add(new BdaysViewModel(names[i]));
        }
        return viewModelsList;
    }
}

