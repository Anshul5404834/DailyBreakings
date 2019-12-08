package com.example.mylenovo.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class FRONT extends AppCompatActivity {
    Bitmap bm;
    private String URL;

    protected FRONT(String A) {
        this.URL = A;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        WebView W = (WebView) findViewById(R.id.wv);
        W.loadUrl("https://newsapi.org/s/the-times-of-india-api");


    }

}
