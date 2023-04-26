package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizList extends AppCompatActivity {

    Button quiz1,quiz2,quiz3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
        quiz1 = findViewById(R.id.quiz1);
        quiz2 = findViewById(R.id.quiz2);
        quiz3 = findViewById(R.id.quiz3);


        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizList.this,Quiz.class);
                startActivity(intent);
            }
        });
        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizList.this,Quiz2.class);
                startActivity(intent);
            }
        });
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizList.this,Quiz3.class);
                startActivity(intent);
            }
        });

    }
}