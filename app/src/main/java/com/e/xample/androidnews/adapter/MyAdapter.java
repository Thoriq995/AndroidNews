package com.e.xample.androidnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.xample.androidnews.R;
import com.e.xample.androidnews.RetrofitJSON.DetailBerita;
import com.e.xample.androidnews.RetrofitJSON.News;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<News> newsList;

    public MyAdapter(Context context, List<News> newsList){
        this.context = context;
        this.newsList = newsList;
    }

    class MyclassAdapter extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        private ImageLoader imageloader;
        private LinearLayout click;

        public MyclassAdapter(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            imageloader = ImageLoader.getInstance();
            click = itemView.findViewById(R.id.click);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.adapter_news,parent,false);

        return new MyclassAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((MyclassAdapter) holder).title.setText(newsList.get(position).getTitle());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .build();

        ((MyclassAdapter) holder).imageloader.init(configuration);
        ((MyclassAdapter) holder).imageloader.displayImage(newsList.get(position).getUrltoImage(), ((MyclassAdapter) holder).img);
        ((MyclassAdapter) holder).click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"kamu klik" +  newsList.get(position).getTitle(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailBerita.class);
                intent.putExtra("title",newsList.get(position).getTitle());
                intent.putExtra("urlToimage",newsList.get(position).getUrltoImage());
                intent.putExtra("content",newsList.get(position).getContent());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
