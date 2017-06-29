package com.example.android.booksapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by lenovo on 6/28/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private ArrayList<News> newsArrayList;

    Bitmap bitmap;
    private Context context;
    public NewsAdapter(ArrayList<News> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
    }



    public NewsAdapter(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

     void updateNewsList(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
        notifyDataSetChanged();
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.item_news,parent,false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {

        holder.title.setText(newsArrayList.get(position).getTitle());
        holder.author.setText(newsArrayList.get(position).getAuthor());
        holder.description.setText(newsArrayList.get(position).getDescription());
        holder.url.setText(newsArrayList.get(position).getUrl());
        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse(newsArrayList.get(position).getUrl());
                Intent i=new Intent(Intent.ACTION_VIEW,uri);

                context.startActivity(i);

            }
        });
        holder.UrlToImage.setText(newsArrayList.get(position).getUrlToImage());
        holder.imageView.setImageBitmap(newsArrayList.get(position).getBitmap());
        holder.publishedAt.setText(newsArrayList.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView title,author,description,url,UrlToImage,publishedAt;
        ImageView imageView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageview);
            title= (TextView) itemView.findViewById(R.id.title);
            author= (TextView) itemView.findViewById(R.id.author);
            description=(TextView)itemView.findViewById(R.id.description);
            url=(TextView)itemView.findViewById(R.id.url);
            UrlToImage=(TextView)itemView.findViewById(R.id.urlToImage);
            publishedAt=(TextView)itemView.findViewById(R.id.publishedAt);

        }
    }
}
