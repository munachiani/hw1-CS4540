package com.example.rkjc.news_app_2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {
    public static ArrayList<NewsItem> parseNews(String jObject){


        ArrayList<NewsItem> newsItemList = new ArrayList<>();

        try{

            JSONObject mainJSONObject = new JSONObject(jObject);
            JSONArray articles = mainJSONObject.getJSONArray("articles");


            Log.d("test", String.valueOf(articles.length()));
            for(int i = 0; i < articles.length(); i++){
                JSONObject item = articles.getJSONObject(i);
                Log.d("test", item.getString("author"));
                // Log.d("test", item.getString("title"));

//                String authorName = item.getString("author");
//                String title = item.getString("title");
//                String url = item.getString("url");
//                String description = item.getString("description");

                newsItemList.add(new NewsItem(item.getString("author"),item.getString("title"),item.getString("description"),item.getString("url"),item.getString("urlToImage"),item.getString("publishedAt")));

                //  Log.d("test", String.valueOf(newsItemList.add(new NewsItem(authorName,title,url,publishedDate))));

            }

        }catch(JSONException e){
            e.printStackTrace();
        }

        return newsItemList;
    }


}


