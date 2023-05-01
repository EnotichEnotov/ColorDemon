package com.example.colordemon.MainMenuAdditionals;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.colordemon.activities.MainActivity;

public class DownloadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(DownloadActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
