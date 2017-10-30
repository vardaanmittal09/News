package com.example.android.booksapi;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 7/5/2017.
 */

public class Buzzfeed extends AppCompatActivity {
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    RecyclerView rv;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingpage);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        progressDialog=new ProgressDialog(Buzzfeed.this);
        progressDialog.setMessage("Downloading News");
        progressDialog.show();
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        rv=(RecyclerView)findViewById(R.id.rvList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter newsAdapter=new NewsAdapter(new ArrayList<News>(),Buzzfeed.this);
        rv.setAdapter(newsAdapter);

        DownloadTask downloadTask=new DownloadTask(new DownloadTask.OnDownloadListener() {
            @Override
            public void OnDownloaded(ArrayList<News> news) {
                Toast.makeText(Buzzfeed.this,
                        "News downloaded = " + news.size(),
                        Toast.LENGTH_SHORT).show();

                newsAdapter.updateNewsList(news);
            }
        });
        downloadTask.execute("https://newsapi.org/v1/articles?source=buzzfeed&sortBy=top&apiKey=1b3ac87f366640c9b665affec166ddbb");
    }
}
