package com.dev.External_Api.Model;

import lombok.Data;

@Data
public class TrumpArticles {
    private TrumpSource source;
    private String author;
    private String title;
    private  String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;


}
