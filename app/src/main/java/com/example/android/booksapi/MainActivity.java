package com.example.android.booksapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        rv=(RecyclerView)findViewById(R.id.rvList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter newsAdapter=new NewsAdapter(new ArrayList<News>(),MainActivity.this);
        rv.setAdapter(newsAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadTask downloadTask=new DownloadTask(new DownloadTask.OnDownloadListener() {
                    @Override
                    public void OnDownloaded(ArrayList<News> news) {
                        Toast.makeText(MainActivity.this,
                                "News downloaded = " + news.size(),
                                Toast.LENGTH_SHORT).show();

                        newsAdapter.updateNewsList(news);
                    }
                });

                downloadTask.execute(" https://newsapi.org/v1/articles?source=espn-cric-info&sortBy=top&apiKey=1b3ac87f366640c9b665affec166ddbb");
            }
        });
    }
}
