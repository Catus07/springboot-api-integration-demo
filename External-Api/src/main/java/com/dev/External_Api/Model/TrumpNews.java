package com.dev.External_Api.Model;

import lombok.Data;

import java.util.List;
@Data
public class TrumpNews {
    private String status;
    private int totalResults;
    private List<TrumpArticles> articles;


}
