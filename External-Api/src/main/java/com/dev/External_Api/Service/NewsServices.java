package com.dev.External_Api.Service;

import com.dev.External_Api.Model.NewsResponse;
import com.dev.External_Api.Model.TrumpNews;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NewsServices {
    //api key
    @Value("${newsapi.key}")
    private String apiKey;

    private final RestClient client = RestClient.create();

    public NewsResponse getTopHeadlines(String country){
        return client.get()
                .uri("https://newsapi.org/v2/top-headlines?country={country}&apikey={apiKey}",country,apiKey)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("client error while fetching news" + response.getStatusCode());
                }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("server error while fetching news"+response.getStatusCode());
                }).body(NewsResponse.class);
    }

    public TrumpNews topHeadlines(String name){
      return client.get()
              .uri("https://newsapi.org/v2/top-headlines?q={name}&apiKey={apiKey}",name,apiKey)
              .accept(MediaType.APPLICATION_JSON).retrieve().onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                  throw new RuntimeException("client error" + response.getStatusCode());
              }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                  throw new RuntimeException("server error"+response.getStatusCode());
              }).body(TrumpNews.class);

    }
}
