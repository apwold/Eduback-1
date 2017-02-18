package com.example.anna.eduback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivityProfessor extends AppCompatActivity {

    String[] fag = new String[]{"Matematikk1", "Objektorientert Programmering", "Diskret Matematikk"};

    ListView FagListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_professor);
    }
}
