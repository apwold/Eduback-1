package com.example.anna.eduback;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Fag extends AppCompatActivity {

    String fagNavn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fag);

        try {
            URL url = new URL("http://www.ime.ntnu.no/api/course/en/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Please provide a course code");
        String code = reader.nextLine();

        //Fetch the course
        String course =

                requests.get(url + code).json();


        //Get relevant data and print it
        code = course["course"]["code"];
        String name = course["course"]["name"];

        String exam_date = course["course"]["assessment"][0]["date"];

        System.out.println("Exam date for" + code + name + "is" + exam_date);

    }



}
