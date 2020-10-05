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
    private TextView youLose;
    private EditText userInput;
    public int i = 0;
    public int max = 100;
    public int min = 0;
    public double x = Math.round((Math.random() * ((max - min) + 1)) + min);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Number Guess Game");

        desc = findViewById(R.id.desc);
        desc.setText("You have 5 trials to guess a random generated number between 0 and 100. You have 5 attempts and will be told if the number is higher or lower");

        guessButton = findViewById(R.id.guessButton);
        guessButton.setText("Go");
        higher = findViewById(R.id.higher);
        lower = findViewById(R.id.lower);
        youLose = findViewById(R.id.youLose);
        userInput = findViewById(R.id.userInput);


        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int guess = Integer.parseInt(userInput.getText().toString());
                    if (checkGuess((int) x, guess)) {

                    } else {
                        guessButton.setText("try again");
                    }
                    i++;
                    if (i==5&&!checkGuess((int)x, guess)){
                        guessButton.setVisibility(View.INVISIBLE);
                        youLose.setVisibility(View.VISIBLE);
                        higher.setVisibility(View.INVISIBLE);
                        lower.setVisibility(View.INVISIBLE);

                    }
            }
        });
    }

    private boolean checkGuess(int number, int guess) {
        if (number == guess) {
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);

            return true;
        } else if (number < guess) {
            lower.setVisibility(View.VISIBLE);
            higher.setVisibility(View.INVISIBLE);
        } else {
            lower.setVisibility(View.INVISIBLE);
            higher.setVisibility(View.VISIBLE);
            return false;
        } return false;
    }
}
