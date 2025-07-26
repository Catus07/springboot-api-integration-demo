package com.dev.External_Api.Service;

import com.dev.External_Api.Model.JsonModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestClientService {
    // no basic auth
    public JsonModel getJsonModel(){
        RestClient restClient = RestClient.create();
        return  restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve().onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                    throw new RuntimeException("client error" + response.getStatusCode());
                }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("Server error" + response.getStatusCode());
                })
                .body(JsonModel.class);
    }

    public List<JsonModel> externalApi2(){
        RestClient client = RestClient.create();
        return client.get()
              .uri("https://jsonplaceholder.typicode.com/posts")
              .retrieve().onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                    throw new RuntimeException("client error" + response.getStatusCode());
                }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("Server error" + response.getStatusCode());
                }).body(new ParameterizedTypeReference<>() {
                });
    }

}
