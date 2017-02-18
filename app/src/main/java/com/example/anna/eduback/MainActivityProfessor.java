package com.example.anna.eduback;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivityProfessor extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] fag = new String[]{"Matematikk1", "Objektorientert Programmering", "Diskret Matematikk"};

    ListView FagListView;
    Button NewFagButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_professor);

       FagListView = (ListView) findViewById(R.id.FagListView);
        NewFagButton = (Button) findViewById(R.id.newFag);

        //Lage en view for hvordan hver linje i lista skal se ut. Typ lite bilde helt til venstre, kun tekst osv.
        //Simple list item 1 er kun tekst, nr 2 er med bilde. her kan man lage hva man vil.
        ArrayAdapter<String> FagAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, fag);

        FagListView.setAdapter(FagAdapter);

        FagListView.setOnItemClickListener(this);

        NewFagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent callIntent = new Intent(Intent.ACTION_DIAL, myPhoneNumber);
                startActivity(callIntent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent moveToDetailIntent = new Intent(getBaseContext(), Fag.class);
        moveToDetailIntent.putExtra("Fag", fag[position]);
        startActivity(moveToDetailIntent);

    }
}
