package com.example.prealphabirthday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddEditScreen extends AppCompatActivity {

    private static final String TAG = "AddEditScreen";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Starting activity.");
        setContentView(R.layout.add_edit);
        Button btnSave = findViewById(R.id.b_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked Save btn.");
                Intent saveIntent = new Intent(AddEditScreen.this, MainActivity.class);
                startActivity(saveIntent);
            }
        });
    }
}
