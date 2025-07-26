package com.dev.External_Api.Service;

import com.dev.External_Api.Model.PesaPalResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PesaPalAccessToken {
    @Value("${consumer.key}")
    private String consumerKey;

    @Value("${consumer.secret}")
    private String secretKey;

    @Value("${pesapal.base.url}")
    private String baseUrl;

    private RestClient restClient;

    private final String TOKEN_ENDPOINT="/api/Auth/RequestToken";

    @PostConstruct
    public void init(){
        restClient =  RestClient.builder().baseUrl(baseUrl).build();
    }
    public PesaPalResponse getAccessToken(){
          String requestBody = "{\"consumer_key\":\"" + consumerKey + "\",\"consumer_secret\":\"" + secretKey + "\"}";
        return restClient.post()
                .uri(TOKEN_ENDPOINT)
                .body(requestBody)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                    throw new RuntimeException("client error");
                }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("server error");
                }).body(PesaPalResponse.class);
    }


}
