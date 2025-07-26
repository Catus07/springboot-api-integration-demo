package com.dev.External_Api.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //adds no-argument constructor(needed for jackson)
public class JsonModel {
    private int userId;
    private int id;
    private String title;
    private  String body;



}
