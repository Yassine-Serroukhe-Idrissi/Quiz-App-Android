package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity implements View.OnClickListener{

    TextView question_nbr;
    Button rep1,rep2,rep3,rep4,submit;
    TextView question;

    int score = 0;
    int nb_question = Questions.question.length;
    int num_question = 0;
    String choix_rep = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question_nbr = findViewById(R.id.question_nb);
        question = findViewById(R.id.question);
        rep1 = findViewById(R.id.r1);
        rep2 = findViewById(R.id.r2);
        rep3 = findViewById(R.id.r3);
        rep4 = findViewById(R.id.r4);
        submit = findViewById(R.id.submit_r);

        rep1.setOnClickListener(Quiz.this);
        rep2.setOnClickListener(Quiz.this);
        rep3.setOnClickListener(Quiz.this);
        rep4.setOnClickListener(Quiz.this);
        submit.setOnClickListener(this);

        question_nbr.setText("Total question : "+nb_question);

        genererQuestion();
    }

    @Override
    public void onClick(View view) {
        rep1.setBackgroundColor(Color.WHITE);
        rep2.setBackgroundColor(Color.WHITE);
        rep3.setBackgroundColor(Color.WHITE);
        rep4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_r)
        {
            if(choix_rep.equals(Questions.correctAnswers[num_question])) {
                score++;
            }
            num_question++;
            genererQuestion();
            Log.d("ScoreT","score"+score);
        }
        else{
                choix_rep = clickedButton.getText().toString();
                clickedButton.setBackgroundColor(Color.rgb(255, 127, 127));
        }

    }
    void genererQuestion() {
        if(num_question == nb_question)
        {
            finQuiz();
            return;
        }
        question.setText(Questions.question[num_question]);
        rep1.setText(Questions.choix[num_question][0]);
        rep2.setText(Questions.choix[num_question][1]);
        rep3.setText(Questions.choix[num_question][2]);
        rep4.setText(Questions.choix[num_question][3]);
    }

    void finQuiz() {
        Intent intent = new Intent(Quiz.this,Resultat.class);
        intent.putExtra("score",score);
        startActivity(intent);
        finish();
    }

    void restartQuiz() {
        score = 0;
        num_question = 0;
        genererQuestion();
    }


}