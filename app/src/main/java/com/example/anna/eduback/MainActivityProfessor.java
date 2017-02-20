package com.example.anna.eduback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivityProfessor extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<String> fagliste = new ArrayList<String>();

    public void setFagliste(ArrayList<String> fagliste) {
        this.fagliste = fagliste;
        fagliste.add("Matematikk1");
        fagliste.add("Objektorientert Programmering");
        fagliste.add("Diskret Matematikk");
    }

    ListView FagListView;
    Button AddFagButton;
    final TextView tvData = (TextView) findViewById(R.id.tvJsonItem);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_professor);

       FagListView = (ListView) findViewById(R.id.FagListView);
        AddFagButton = (Button) findViewById(R.id.AddFagButton);

        //Lage en view for hvordan hver linje i lista skal se ut. Typ lite bilde helt til venstre, kun tekst osv.
        //Simple list item 1 er kun tekst, nr 2 er med bilde. her kan man lage hva man vil.
        ArrayAdapter<String> FagAdapter;
        FagAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, fagliste);

        FagListView.setAdapter(FagAdapter);

        FagListView.setOnItemClickListener(this);

        AddFagButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;


                try {
                    URL url = new URL("http://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();

                    InputStream stream = urlConnection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(stream));


                    StringBuffer buffer = new StringBuffer();

                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    tvData.setText(buffer.toString());


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent moveToDetailIntent = new Intent(getBaseContext(), Fagside.class);
                moveToDetailIntent.putExtra("Fag", fagliste.get(position));
                startActivity(moveToDetailIntent);

            }
        });
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}