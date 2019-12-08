package com.example.mylenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l = (ListView) findViewById(R.id.listview);
        task_updated a = new task_updated();
        a.execute("https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=787aa25485844c788c76fba73a6e887a");
    }
}
//समाचार