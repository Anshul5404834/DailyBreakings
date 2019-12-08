package com.example.mylenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_raw extends Activity {

    int i = 0;

    String strings;

    display_raw(String string) {
        this.strings = string;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raw1);

    }

    public void main(String string) {
        this.strings = string;
        TextView t1 = (TextView) findViewById(R.id.textView1);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        ImageButton imageButton = findViewById(R.id.TTS);
        TextView t3 = (TextView) findViewById(R.id.textView3);
        LinearLayout linearLayout = findViewById(R.id.ll);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        try {
            JSONObject parentobject;
            JSONArray parentarray;
            parentobject = new JSONObject(string);
            parentarray = parentobject.getJSONArray("articles");
            while (i < parentarray.length()) {
                final JSONObject mainblocks = parentarray.getJSONObject(i);
                t1.setText(mainblocks.optString("title").toString());
                t2.setText(mainblocks.optString("description").toString());
                t3.setText(mainblocks.optString("publishedAt").toString());
                Glide.with(getApplicationContext()).load(mainblocks.optString("urlToImage")).into(iv);
                final Intent WEB = new Intent(Intent.ACTION_VIEW);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WEB.setData((Uri) mainblocks.opt("url"));
                    }
                });

                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = i++;
                        main(strings);
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
