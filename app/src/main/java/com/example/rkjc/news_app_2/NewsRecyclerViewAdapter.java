package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {

    public Context mContext;
    public ArrayList<NewsItem> mNewsItems;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.mContext = context;
        this.mNewsItems = newsItems;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_item, viewGroup, shouldAttachToParentImmediately);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.NewsViewHolder newsHolder, int i) {
        newsHolder.bind(i);

    }

    @Override
    public int getItemCount() {
        return mNewsItems.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView title;
        ImageView image;
        TextView url;
        TextView description;
        TextView publishedDate;

        public NewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.news_title);
            //image = itemView.findViewById(R.id.imageViewThumbnail);
            publishedDate = itemView.findViewById(R.id.published_at);
            description = itemView.findViewById(R.id.description);

        }

        void bind(final int listIndex) {

            String by = "By ";

            author.setText(by + mNewsItems.get(listIndex).getAuthor());
            title.setText("Title: "+ mNewsItems.get(listIndex).getTitle());
            description.setText("Description: " + mNewsItems.get(listIndex).getDescription());


            publishedDate.setText("Date: " + mNewsItems.get(listIndex).getPublishedAt());


//            Uri uri = Uri.parse(mNewsItems.get(listIndex).getImage());
//            if (uri != null) {
//                Picasso.get().load(uri).into(image);
//
//            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String urlString = mNewsItems.get(listIndex).getUrl();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                   // Intent browserChooserIntent = Intent.createChooser(browserIntent, "Choose browser of your choice");
                    mContext.startActivity(browserIntent);

                }
            });


        }


    }


}
