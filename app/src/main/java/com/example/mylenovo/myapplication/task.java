package com.example.mylenovo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class task extends AsyncTask<String, String, List<news>> {

    HttpURLConnection connection;
    URL url;
    ListView l;
    InputStream stream = null;
    StringBuffer data;
    List<news> news = new ArrayList<>();
    Intent WEB = new Intent(Intent.ACTION_VIEW);

    public task(ListView L) {
        l = L;
    }

    @Override
    protected List<com.example.mylenovo.myapplication.news> doInBackground(String... strings) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        {
            try {
                JSONObject parentobject;
                JSONArray parentarray;
                parentobject = new JSONObject(data.toString());
                parentarray = parentobject.getJSONArray("articles");
                for (int i = 0; i < parentarray.length(); i++) {
                    JSONObject mainblocks = parentarray.getJSONObject(i);
                    news.add(new news(mainblocks.optString("title").toString(), mainblocks.optString("description").toString(), mainblocks.optString("publishedAt").toString(), mainblocks.optString("urlToImage"), mainblocks.opt("url").toString()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return news;
    }

    @Override
    protected void onPostExecute(final List<com.example.mylenovo.myapplication.news> news) {
        super.onPostExecute(news);
        adapter a = new adapter(l.getContext(), news);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                news a = news.get(position);
                String url = a.getURL();
                WEB.setData(Uri.parse(url));

            }
        });
    }
}
