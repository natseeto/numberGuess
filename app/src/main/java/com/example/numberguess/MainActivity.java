package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button guessButton;
    private TextView desc;
    private TextView higher;
    private TextView lower;
    private TextView number;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Number Guess Game");
        
        desc = findViewById(R.id.desc);
        desc.setText("You have 5 trials to guess a random generated number between 0 and 100. You have 5 attempts and will be told if the number is higher or lower");

        guessButton = findViewById(R.id.guessButton);
        higher = findViewById(R.id.higher);
        lower = findViewById(R.id.lower);
        number = findViewById(R.id.number);
        userInput = findViewById(R.id.userInput);


        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int max = 100;
                int min = 0;
                double x = Math.round((Math.random() * ((max - min) + 1)) + min);
                    int guess = Integer.parseInt(userInput.getText().toString());
                    if (checkGuess((int) x, guess)) {
                        guessButton.setText("Good shit");
                    } else {
                        guessButton.setText("try again bitch");
                    }
            }
        });
    }

    private boolean checkGuess(int number, int guess) {
        if (number == guess) {
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
            higher.setVisibility(View.INVISIBLE);
            lower.setVisibility(View.INVISIBLE);
            return true;
        } else if (number < guess) {
            higher.setVisibility(View.VISIBLE);
            lower.setVisibility(View.INVISIBLE);
        } else {
            higher.setVisibility(View.INVISIBLE);
            lower.setVisibility(View.VISIBLE);
            return false;
        } return false;
    }
}
