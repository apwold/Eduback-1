package com.example.anna.eduback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LearningGoals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_goals);
        System.out.println("Denne siden er for å legge inn og vise læringsmål");
    }
}
