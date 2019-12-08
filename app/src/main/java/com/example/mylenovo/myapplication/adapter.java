package com.example.mylenovo.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapter extends ArrayAdapter {
    private Context mcontext;
    private List<news> news;

    public adapter(Context context, List<news> news) {
        super(context, 0, news);
        this.news = news;
        this.mcontext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View m = convertView;
        if (m == null) {
            m = LayoutInflater.from(mcontext).inflate(R.layout.raw1, parent, false);
        }
        news a = news.get(position);

        TextView t1 = (TextView) m.findViewById(R.id.textView1);
        TextView t2 = (TextView) m.findViewById(R.id.textView2);
        TextView t3 = (TextView) m.findViewById(R.id.textView3);
        ImageView i = (ImageView) m.findViewById(R.id.imageView);
        t1.setText(a.getContent());
        t2.setText(a.getDate());
        t3.setText(a.getDescription());
        Glide.with(mcontext).load(a.getImage()).into(i);


        return m;

    }
}

