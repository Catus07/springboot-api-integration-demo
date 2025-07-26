package com.dev.External_Api.Service;

import com.dev.External_Api.Model.FinanceModel;
import com.dev.External_Api.Model.SearchModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class FinancialService {
    //api key
    @Value("${financialapi.key}")
    private String apiKey;

    private final RestClient restClient=RestClient.create();

    public List<FinanceModel> getFinancialData(){
        return restClient.get()
                .uri("https://financialmodelingprep.com/stable/search-symbol?query=AAPL&apikey={apiKey}",apiKey)
                .retrieve().onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                    throw new RuntimeException("client error"+response.getStatusCode());
                }).onStatus(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("server error" + response.getStatusCode());
                }).body(new ParameterizedTypeReference<List<FinanceModel>>() {
                });
    }
    public List<SearchModel> searchTickerSymbol() {
        return restClient.get()
                .uri("https://financialmodelingprep.com/stable/search-name?query=AA&apikey={apiKey}", apiKey)
                .retrieve().onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("client error" + response.getStatusCode());
                }).onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("server error" + response.getStatusCode());
                }).body(new ParameterizedTypeReference<List<SearchModel>>() {
                });
    }

}
