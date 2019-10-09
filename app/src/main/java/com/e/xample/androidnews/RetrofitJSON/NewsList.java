package com.e.xample.androidnews.RetrofitJSON;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {

    @SerializedName("status")
    String status;

    @SerializedName("totalResults")
    String totalresults;

    @SerializedName("articles")
    List<News> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
