package com.example.android.fifatrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        RadioButton trueAnswer = findViewById(R.id.trueRadioButton);
        boolean isTrue = trueAnswer.isChecked();

        EditText russiaText = findViewById(R.id.russiaEditText);
        String hostCountry = russiaText.getText().toString();

        CheckBox germanyWin = findViewById(R.id.germanyCheckBox);
        boolean isGermany = germanyWin.isChecked();
        CheckBox italyWin = findViewById(R.id.italyCheckBox);
        boolean isItaly = italyWin.isChecked();

        RadioButton uruguay = findViewById(R.id.uruguayRadioButton);
        boolean isUruguay = uruguay.isChecked();

        EditText spain = findViewById(R.id.spainEditText);
        String winner = spain.getText().toString();

        RadioButton brazil = findViewById(R.id.brazil);
        boolean isBrazil = brazil.isChecked();

        calculateAnswer(isTrue, hostCountry, isGermany, isItaly, isUruguay, winner, isBrazil);
        Toast.makeText(this, "You got " + score + " right answers out of 6", Toast.LENGTH_SHORT).show();
    }

    private int calculateAnswer(boolean isTrue, String hostCountry, boolean isGermany, boolean isItaly,
                                boolean isUruguay, String winner, boolean isBrazil) {
        if (isTrue) {
            score++;
        }

        if (hostCountry.equals("RUSSIA")) {
            score++;
        }

        if (isGermany && isItaly) {
            score++;
        }

        if (isUruguay) {
            score++;
        }

        if (winner.equals("SPAIN")) {
            score++;
        }

        if (isBrazil) {
            score++;
        }

        return score;
    }


}
