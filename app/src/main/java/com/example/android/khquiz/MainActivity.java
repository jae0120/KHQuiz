package com.example.android.khquiz;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerGroup1 = findViewById(R.id.q1_radio_group);
        answerGroup2 = findViewById(R.id.q2_radio_group);
        AnswerOne = (CheckBox) findViewById(R.id.q3a1);
        AnswerTwo = (CheckBox) findViewById(R.id.q3a2);
        AnswerThree = (CheckBox) findViewById(R.id.q3a3);
        AnswerFour = (CheckBox) findViewById(R.id.q3a4);
        AnswerFive = (CheckBox) findViewById(R.id.q3a5);
        AnswerSix = (CheckBox) findViewById(R.id.q3a6);
    }

    RadioGroup answerGroup1;
    RadioGroup answerGroup2;
    CheckBox AnswerOne;
    CheckBox AnswerTwo;
    CheckBox AnswerThree;
    CheckBox AnswerFour;
    CheckBox AnswerFive;
    CheckBox AnswerSix;
    int score;
    Boolean q1 = false;
    Boolean q2 = false;
    EditText q4Answer;

    // activates when radio group 1 button is clicked, checks for correct answer
    public void onRadioButtonClicked(View view) {
        // Check which radio button was clicked
        if (view.getId() == R.id.q1a2) {
            q1 = true;
        } else {
            q1 = false;
        }

    }

    // activates when radio group 2 button is clicked, checks for correct answer
    public void onRadioButton2Clicked(View view) {
        // Check which radio button was clicked
        if (view.getId() == R.id.q2a3) {
            q2 = true;
        } else {
            q2 = false;
        }

    }
    //check if Question One is correct

    private void checkQ1() {
        if (q1) {
            score++;
        }
    }

    //check if Question Two is correct
    private void checkQ2() {
        if (q2) {
            score++;
        }
    }

    //method to check the checkbox question

    public void checkQ3() {
        Boolean Q3A1 = AnswerOne.isChecked();
        Boolean Q3A2 = AnswerTwo.isChecked();
        Boolean Q3A3 = AnswerThree.isChecked();
        Boolean Q3A4 = AnswerFour.isChecked();
        Boolean Q3A5 = AnswerFive.isChecked();
        Boolean Q3A6 = AnswerSix.isChecked();
        if (Q3A1 && Q3A2 && Q3A3 && Q3A4 && !Q3A5 && !Q3A6) {
            score++;
        }
    }

    // Method to check the edittext question

    public void checkQ4() {
        q4Answer = (EditText) findViewById(R.id.q4_edit_text);
        String guestAnswer = q4Answer.getText().toString();
        if ((guestAnswer.equalsIgnoreCase("Xion")) || (guestAnswer.equalsIgnoreCase("Shion")) || (guestAnswer.equalsIgnoreCase("Xion.")) || (guestAnswer.equalsIgnoreCase("Xion "))) {
            score++;
        }
    }

    //submitScore button
    public void submitScore(View view) {
        checkQ1();
        checkQ2();
        checkQ3();
        checkQ4();
        Toast.makeText(getApplicationContext(), scoreMessage(), Toast.LENGTH_SHORT).show();
        score = 0;
    }

    //determines score message
    public String scoreMessage() {
        String scoreString = "" + score;
        switch (score) {
            case (0):
            default: {
                return getString(R.string.zero_score, scoreString);
            }
            case (1): {
                return getString(R.string.score_one, scoreString);
            }
            case (2): {
                return getString(R.string.score_two, scoreString);
            }
            case (3): {
                return getString(R.string.score_three, scoreString);
            }
            case (4): {
                return getString(R.string.score_perfect, scoreString);
            }

        }

    }

    //reset scores
    public void resetScores(View view) {
        score = 0;
        answerGroup1.clearCheck();
        answerGroup2.clearCheck();
        if (AnswerOne.isChecked()) AnswerOne.toggle();
        if (AnswerTwo.isChecked()) AnswerTwo.toggle();
        if (AnswerThree.isChecked()) AnswerThree.toggle();
        if (AnswerFour.isChecked()) AnswerFour.toggle();
        if (AnswerFive.isChecked()) AnswerFive.toggle();
        if (AnswerSix.isChecked()) AnswerSix.toggle();
        q1 = false;
        q2 = false;
        q4Answer.setText("");
    }
}
