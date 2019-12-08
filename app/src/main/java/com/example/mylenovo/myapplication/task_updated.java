package com.example.mylenovo.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class task_updated extends AsyncTask<String, String, String> {
    HttpURLConnection connection;
    URL url;
    InputStream stream = null;
    StringBuffer data;

    @Override
    protected String doInBackground(String... strings) {
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            stream = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(stream));
        data = new StringBuffer();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        display_raw display_raw = new display_raw(s);
        display_raw.main(s);
    }
}
