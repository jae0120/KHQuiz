package com.example.android.khquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup answerGroup1;
    RadioGroup answerGroup2;
    private RadioButton radioAnswer1Button;
    private RadioButton radioAnswer2Button;
    Button submitScore = findViewById(R.id.submit_score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerGroup1 = findViewById(R.id.q1_radio_group);
        answerGroup2 = findViewById(R.id.q2_radio_group);

    }

    int score;

    // method to check q1
    public void checkq1() {
        int selectedId = answerGroup1.getCheckedRadioButtonId();
        radioAnswer1Button = (RadioButton) findViewById(selectedId);
        if (radioAnswer1Button.getText() == "2002") {
            score++;
        }
    }
    // method to check q2
    public void checkQ2() {
        int selectedId = answerGroup2.getCheckedRadioButtonId();
        radioAnswer2Button = (RadioButton) findViewById(selectedId);
        if (radioAnswer2Button.getText() == "Deep Jungle") {
            score++;
        }
    }





 /*   public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1a1:
                if (checked)
                    break;
            case R.id.q1a2:
                if (checked)
                    //correct answer
                    score++;
                else score--;
                break;
            case R.id.q1a3:
                if (checked)
                    break;
            case R.id.q1a4:
                if (checked)
                    break;


        }

    }
*/

    //method to check the checkbox question

    public void checkQ3() {
        CheckBox AnswerOne = (CheckBox) findViewById(R.id.q3a1);
        Boolean Q3A1 = AnswerOne.isChecked();
        CheckBox AnswerTwo = (CheckBox) findViewById(R.id.q3a2);
        Boolean Q3A2 = AnswerTwo.isChecked();
        CheckBox AnswerThree = (CheckBox) findViewById(R.id.q3a3);
        Boolean Q3A3 = AnswerThree.isChecked();
        CheckBox AnswerFour = (CheckBox) findViewById(R.id.q3a4);
        Boolean Q3A4 = AnswerFour.isChecked();
        CheckBox AnswerFive = (CheckBox) findViewById(R.id.q3a5);
        Boolean Q3A5 = AnswerFive.isChecked();
        CheckBox AnswerSix = (CheckBox) findViewById(R.id.q3a6);
        Boolean Q3A6 = AnswerSix.isChecked();
        if (Q3A1 && Q3A2 && Q3A3 && Q3A4 && !Q3A5 && !Q3A6) {
            score++;
        }
    }

    // Method to check the edittext question

    public void checkQ4() {
        EditText q4Answer = (EditText) findViewById(R.id.q4_edit_text);
        String guestAnswer = q4Answer.getText().toString();
        Log.v("MainActivity", guestAnswer);
        if ((guestAnswer == "Xion") //|| (guestAnswer == "Shion") || (guestAnswer == "Xion.") || (guestAnswer == "Xion ")
                ) {
            score++;
        }
    }

    submitScore.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View v){
        //is called when submit button is pushed. Checks answers and determines results.
        //  public void submitScore(View view) {
        checkq1();
        checkQ2();
        checkQ3();
        checkQ4();
        String results = "Congratulations! You got " + score + " correct!";
        displayScore(results);
    }
    }

//displays the results
private void displayScore(String results){
        TextView scoreText=(TextView)findViewById(R.id.results_text_view);
        String checkText=(String)scoreText.getText();
        if(checkText.isEmpty())
        scoreText.setText(results);

        }

//reset scores
public void resetScores(View view){
        TextView scoreText=(TextView)findViewById(R.id.results_text_view);
        scoreText.setText("");
        score=0;
        answerGroup1.clearCheck();
        answerGroup2.clearCheck();
        }
        }
