package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Number Guess Game");

        desc = findViewById(R.id.desc);
        desc.setText("You have 5 trials to guess a random generated number between 0 and 100. You have 5 attempts and will be told if the number is higher or lower");
    }
}