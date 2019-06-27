package com.example.prealphabirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set with layout's resource ID
        BdaysAdapter adapter = new BdaysAdapter(generateBVMList()); // Instantiate adapter
        RecyclerView bdaysView = (RecyclerView) findViewById(R.id.bdays_view);
        bdaysView.setLayoutManager(new LinearLayoutManager(this));
        bdaysView.setHasFixedSize(true);
        bdaysView.setAdapter(adapter);
        Log.d(TAG, "onCreate: Starting activity.");
        Button btnAddEdit = (Button) findViewById(R.id.b_add_new);
        btnAddEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked Add btn.");
                Intent addIntent = new Intent(MainActivity.this, AddEditScreen.class);
                startActivity(addIntent);
            }
        });
    }

    private List<BdaysViewModel> generateBVMList() {
        // Create list of BdaysViewModel to pass into adapter
        final List<BdaysViewModel> viewModelsList = new ArrayList<>();

        InputStream inputStream = getResources().openRawResource(R.raw.bday_data);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> nameList = csvFile.read();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        // ParsePosition parsePos = new ParsePosition(0);
        Date date = new Date();

        for(String[] rowData: nameList) {
            String name = rowData[0];
            try {
                date = dateFormatter.parse(rowData[1]);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            viewModelsList.add(new BdaysViewModel(name, date));
        }

        // Stream method, only available J8
        // nameList.stream().forEach((name) -> viewModelsList.add(new BdaysViewModel(name)));

        return viewModelsList;
    }
}

