package com.e.xample.androidnews.Retrofitconfig;

public class RetrofitConfigToJson {

    public static String URL_API = "https://newsapi.org/";

    public static GetJsonAll getResponses(){

        return Retrofitinstance.getinstance(URL_API).create(GetJsonAll.class);


    }
}
