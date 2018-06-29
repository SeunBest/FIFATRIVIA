package com.example.android.fifatrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app quizzes a user about FIFA.
 */

public class MainActivity extends AppCompatActivity {

    // Initializes yhe user's score to zero
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Submit button is clicked.
     */
    public void submit(View view) {
        // Get's the state of the radio button and stores it in a boolean
        RadioButton trueAnswer = findViewById(R.id.trueRadioButton);
        boolean isTrue = trueAnswer.isChecked();

        // Get's the state of EditText and stores it in a String
        EditText russiaText = findViewById(R.id.russiaEditText);
        String hostCountry = russiaText.getText().toString().toUpperCase();

        // Get's the state of the radio buttons and stores them in a booleans
        CheckBox germanyWin = findViewById(R.id.germanyCheckBox);
        boolean isGermany = germanyWin.isChecked();
        CheckBox italyWin = findViewById(R.id.italyCheckBox);
        boolean isItaly = italyWin.isChecked();

        // Get's the state of the radio button and stores it in a boolean
        RadioButton uruguay = findViewById(R.id.uruguayRadioButton);
        boolean isUruguay = uruguay.isChecked();

        // Get's the state of the EditText and stores it in a String
        EditText spain = findViewById(R.id.spainEditText);
        String winner = spain.getText().toString().toUpperCase();

        // Get's the state of the radio button and stores it in a boolean
        RadioButton brazil = findViewById(R.id.brazil);
        boolean isBrazil = brazil.isChecked();

        // Calls the calculate price method
        calculateAnswer(isTrue, hostCountry, isGermany, isItaly, isUruguay, winner, isBrazil);

        // Displays a toast message containing the scores of the user
        Toast.makeText(this, "You got " + score + " right answers out of 6", Toast.LENGTH_SHORT).show();

        // Initializes score to zero;
        score = 0;
    }

    /**
     * This method calculates the total score of the user using if statements.
     *
     * @param isTrue      is the state of number one's correct answer Radiobutton
     * @param hostCountry is the content of the  number two's EditText
     * @param isGermany   is the state of number three's Germany Radiobutton
     * @param isItaly     is the state of number three's Italy Radiobutton
     * @param isUruguay   is the state of number four's Uruguay Radiobutton
     * @param winner      is the content of number five's EditText
     * @param isBrazil    is the state of number six's Brazil Radiobutton
     */
    private void calculateAnswer(boolean isTrue, String hostCountry, boolean isGermany, boolean isItaly,
                                 boolean isUruguay, String winner, boolean isBrazil) {
        if (isTrue) score++;

        if (hostCountry.equals("RUSSIA")) score++;

        if (isGermany && isItaly) score++;

        if (isUruguay) score++;

        if (winner.equals("SPAIN")) score++;

        if (isBrazil) score++;
    }
}
