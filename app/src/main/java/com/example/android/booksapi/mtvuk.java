package com.example.android.booksapi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 7/25/2017.
 */

public class mtvuk extends AppCompatActivity{
    RecyclerView rv;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingpage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
        progressDialog=new ProgressDialog(mtvuk.this);
        progressDialog.setMessage("Downloading News");
        progressDialog.show();
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        rv=(RecyclerView)findViewById(R.id.rvList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter newsAdapter=new NewsAdapter(new ArrayList<News>(),mtvuk.this);
        rv.setAdapter(newsAdapter);

        DownloadTask downloadTask=new DownloadTask(new DownloadTask.OnDownloadListener() {
            @Override
            public void OnDownloaded(ArrayList<News> news) {
                Toast.makeText(mtvuk.this,
                        "News downloaded = " + news.size(),
                        Toast.LENGTH_SHORT).show();

                newsAdapter.updateNewsList(news);
            }
        });
        downloadTask.execute("https://newsapi.org/v1/articles?source=mtv-news-uk&sortBy=top&apiKey=1b3ac87f366640c9b665affec166ddbb");
    }
}
