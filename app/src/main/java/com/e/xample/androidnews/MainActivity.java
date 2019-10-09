package com.e.xample.androidnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.e.xample.androidnews.RetrofitJSON.News;
import com.e.xample.androidnews.RetrofitJSON.NewsList;
import com.e.xample.androidnews.Retrofitconfig.GetJsonAll;
import com.e.xample.androidnews.Retrofitconfig.RetrofitConfigToJson;
import com.e.xample.androidnews.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GetJsonAll getJsonAll;
    List<News> newsList;
    String title,description;

    RecyclerView recycler_view;
    MyAdapter myAdapter;
    GridLayoutManager gm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        gm = new GridLayoutManager(this,2);
        recycler_view.setLayoutManager(gm);
        newsList = new ArrayList<>();

        getJsonAll = RetrofitConfigToJson.getResponses();



        getJsonAll.getNewsList("id", "89d66c42e58b490bb180c6e599084b56").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil",response + "");

                newsList = response.body().getArticles();


                title = newsList.get(1).getTitle();
                description = newsList.get(1).getDescription();
                Log.d("titleBerita",title);

                myAdapter = new MyAdapter(getApplication(),newsList);
                recycler_view.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal", t + "");
            }
        });
    }
}
