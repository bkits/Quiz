package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //this array has stored the answer for question 6
    private final static byte lastQuestionCorrectAnswers[] = {1, 0, 0, 0, 1};
    /* this array stores the state of each question (1 if correct, else 0)
       each element represents a question (0 is question 1, 1 is question 2,...)
       the sum of all questions is the amount of right answers
       byte data type was chosen to save memory space
     */
    private byte[] checkCounter = new byte[6];
    /*
        this array saves the state of each answer in question 6 (1 if it is clicked, else 0)
        each element represents an answer (0 is answer 1, 1 is answer 2,...)
     */
    private byte[] checkLastQuestion = new byte[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this method checks the first question with radio buttons (4)
    public void onRadioButtonClickedQuestion1(View view) {
        // check if any button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which button was clicked
        //the state will be saved in checkCounter in position 0
        switch (view.getId()) {
            case R.id.iAnswer11:
                if (checked)
                    // answer 1 is wrong
                    checkCounter[0] = 0;
                break;
            case R.id.iAnswer12:
                if (checked)
                    // answer 2 is wrong
                    checkCounter[0] = 0;
                break;
            case R.id.iAnswer13:
                if (checked)
                    //answer 3 is correct!
                    checkCounter[0] = 1;
                break;
            case R.id.iAnswer14:
                if (checked)
                    // answer 4 is wrong
                    checkCounter[0] = 0;
                break;
        }
    }

    //this method checks the second question with radio buttons (3)
    public void onRadioButtonClickedQuestion2(View view) {
        // check if any button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which button was clicked
        //the state will be saved in checkCounter in position 1
        switch (view.getId()) {
            case R.id.iAnswer21:
                if (checked)
                    // answer 1 wrong
                    checkCounter[1] = 0;
                break;
            case R.id.iAnswer22:
                if (checked)
                    // answer 2 is correct
                    checkCounter[1] = 1;
                break;
        }
    }

    //this method checks the third question with radio buttons (4)
    public void onRadioButtonClickedQuestion3(View view) {
        // check if any button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which button was clicked
        //the state will be saved in checkCounter in position 2
        switch (view.getId()) {
            case R.id.iAnswer31:
                if (checked)
                    // answer 1 is wrong
                    checkCounter[2] = 0;
                break;
            case R.id.iAnswer32:
                if (checked)
                    // answer 2 is wrong
                    checkCounter[2] = 0;
                break;
            case R.id.iAnswer33:
                if (checked)
                    //answer 3 is wrong
                    checkCounter[2] = 0;
                break;
            case R.id.iAnswer34:
                if (checked)
                    // answer 4 is correct
                    checkCounter[2] = 1;
                break;
        }
    }

    //this method checks the fifth question with radio buttons (3)
    public void onRadioButtonClickedQuestion5(View view) {
        // check if any button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // check which button was clicked
        //the state will be saved in checkCounter in position 4
        switch (view.getId()) {
            case R.id.iAnswer51:
                if (checked)
                    // answer 1 is wrong
                    checkCounter[4] = 0;
                break;
            case R.id.iAnswer52:
                if (checked)
                    // answer 2 is wrong
                    checkCounter[4] = 0;
                break;
            case R.id.iAnswer53:
                if (checked)
                    //answer 3 is correct
                    checkCounter[4] = 1;
                break;
        }
    }

    //this method checks if answer 1 for question 6 is checked (1 for yes, 0 for no)
    //the result is stored in checkLastQuestion array in position 0
    public void onClickQuestion61(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            checkLastQuestion[0] = 1;
        else
            checkLastQuestion[0] = 0;
    }

    //this method checks if answer 2 for question 6 is checked (1 for yes, 0 for no)
    //the result is stored in checkLastQuestion array in position 1
    public void onClickQuestion62(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            checkLastQuestion[1] = 1;
        else
            checkLastQuestion[1] = 0;
    }

    //this method checks if answer 3 for question 6 is checked (1 for yes, 0 for no)
    //the result is stored in checkLastQuestion array in position 2
    public void onClickQuestion63(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            checkLastQuestion[2] = 1;
        else
            checkLastQuestion[2] = 0;
    }

    //this method checks if answer 4 for question 6 is checked (1 for yes, 0 for no)
    //the result is stored in checkLastQuestion array in position 3
    public void onClickQuestion64(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            checkLastQuestion[3] = 1;
        else
            checkLastQuestion[3] = 0;
    }

    //this method checks if answer 5 for question 6 is checked (1 for yes, 0 for no)
    //the result is stored in checkLastQuestion array in position 4
    public void onClickQuestion65(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked)
            checkLastQuestion[4] = 1;
        else
            checkLastQuestion[4] = 0;
    }

    //this method will count the correct answers
    public void onClickCheck(View view) {
        EditText text = (EditText) findViewById(R.id.editText);
        //this is the input for the user in the EditBox, question 4
        String valueFromEditText = text.getText().toString();
        //this variable stores the number of the correct answers
        byte checkIfQuizIsSolved = 0;

        //check if question 4 is correct
        if (valueFromEditText.equals("159"))
            checkCounter[3] = 1;
        else
            checkCounter[3] = 0;

        //check if question 6 is correct
        if (Arrays.equals(checkLastQuestion, lastQuestionCorrectAnswers))
            checkCounter[5] = 1;
        else
            checkCounter[5] = 0;

        //count the number of correct answers
        checkIfQuizIsSolved = (byte) (checkCounter[0] + checkCounter[1] + checkCounter[2] + checkCounter[3] + checkCounter[4] + checkCounter[5]);

        //check the state of quiz (fail or success), and display the corresponding state with a toast message
        if (checkIfQuizIsSolved == 6) {//success
            Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
        } else {//fail
            Toast.makeText(getApplicationContext(), "FAIL! You got " + checkIfQuizIsSolved + " corect answers!", Toast.LENGTH_SHORT).show();
        }

    }

}
