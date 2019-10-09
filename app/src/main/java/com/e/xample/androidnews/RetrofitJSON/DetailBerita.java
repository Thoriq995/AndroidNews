package com.e.xample.androidnews.RetrofitJSON;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.e.xample.androidnews.R;

public class DetailBerita extends AppCompatActivity{

    String title;
    TextView titles;
    ImageView image;
    WebView webku;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_berita);

        titles = findViewById(R.id.title);
        image = findViewById(R.id.image);
        webku = findViewById(R.id.webku);
        title = getIntent().getStringExtra("title");

        Log.d("titleku",title);
        Toast.makeText(getApplicationContext(),"KAMU TADI KLIK" + title,Toast.LENGTH_LONG).show();
        titles.setText(title);
    }
}
