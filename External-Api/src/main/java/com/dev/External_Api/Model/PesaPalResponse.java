package com.dev.External_Api.Model;

import lombok.Data;

@Data
public class PesaPalResponse {
    private String token;
    private String expiryDate;
    private Object error;
    private String status;
    private String message;
}
