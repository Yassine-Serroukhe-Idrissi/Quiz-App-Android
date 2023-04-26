package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Resultat extends AppCompatActivity {

    Button log;
    TextView ScoreText;
    Button newQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        int score = 0;
        int Sco = getIntent().getIntExtra("score",score);
        ScoreText = findViewById(R.id.resultat);
        newQuiz = findViewById(R.id.nextb);
        ScoreText.setText("Votre Resultat est "+ Sco);
        log = findViewById(R.id.logout);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Resultat.this,MainActivity.class);
                startActivity(intent);
            }
        });
        newQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultat.this,QuizList.class);
                startActivity(intent);
            }
        });


    }
}