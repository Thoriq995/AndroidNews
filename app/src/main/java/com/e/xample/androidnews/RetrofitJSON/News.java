package com.e.xample.androidnews.RetrofitJSON;

import com.google.gson.annotations.SerializedName;

public class News {

   @SerializedName("author")
   String author;

   @SerializedName("title")
   String title;

   @SerializedName("description")
   String description;

   @SerializedName("urlToImage")
   String urltoImage;

   @SerializedName("publishedAt")
   String  String;

   @SerializedName("content")
   String content;

   public java.lang.String getAuthor() {
      return author;
   }

   public void setAuthor(java.lang.String author) {
      this.author = author;
   }

   public java.lang.String getTitle() {
      return title;
   }

   public void setTitle(java.lang.String title) {
      this.title = title;
   }

   public java.lang.String getDescription() {
      return description;
   }

   public void setDescription(java.lang.String description) {
      this.description = description;
   }

   public java.lang.String getUrltoImage() {
      return urltoImage;
   }

   public void setUrltoImage(java.lang.String urltoImage) {
      this.urltoImage = urltoImage;
   }

   public java.lang.String getString() {
      return String;
   }

   public void setString(java.lang.String string) {
      String = string;
   }

   public java.lang.String getContent() {
      return content;
   }

   public void setContent(java.lang.String content) {
      this.content = content;
   }
}
