package com.example.android.booksapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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

/**
 * Created by lenovo on 6/28/2017.
 */

public class DownloadTask extends AsyncTask<String,Void,ArrayList<News>> {

    Bitmap bitmap;

    interface OnDownloadListener{
        void OnDownloaded(ArrayList<News>news);
    }

    private OnDownloadListener odl;

    public DownloadTask(OnDownloadListener odl) {
        this.odl = odl;
    }
    @Override

    protected ArrayList<News> doInBackground(String... params) {
        ArrayList<News> NewsPost=null;
        try {
            URL url=new URL(params[0]);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));


            StringBuilder sb=new StringBuilder();
            String Buffer ="";
            while(Buffer!=null){
                sb.append(Buffer);
                Buffer=bufferedReader.readLine();
            }

           // JSONArray NewsJsonArr = news JSONArray(sb.toString());

            JSONObject jsonObject=new JSONObject(sb.toString());
            JSONArray jsonArray=jsonObject.getJSONArray("articles");
            NewsPost = new ArrayList<>(jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject NewsJsonArrJSONObject = jsonArray.getJSONObject(i);
                try {
                    

                    bitmap = BitmapFactory.decodeStream((InputStream)new URL(
                            NewsJsonArrJSONObject.getString("urlToImage")).getContent());

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                News news = new News(
                        NewsJsonArrJSONObject.getString("author"),
                        NewsJsonArrJSONObject.getString("title"),
                        NewsJsonArrJSONObject.getString("description"),
                        NewsJsonArrJSONObject.getString("url"),
                        NewsJsonArrJSONObject.getString("urlToImage"),
                        NewsJsonArrJSONObject.getString("publishedAt"),
                        bitmap);

                NewsPost.add(news);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return NewsPost;
    }

    @Override
    protected void onPostExecute(ArrayList<News> newses) {
        if(newses.size()==0){
            return;
        }
        super.onPostExecute(newses);
        odl.OnDownloaded(newses);
    }
}
