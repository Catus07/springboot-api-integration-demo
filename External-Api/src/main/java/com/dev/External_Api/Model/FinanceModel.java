package com.dev.External_Api.Model;

import lombok.Data;

@Data
public class FinanceModel {
    private String symbol;
    private String name;
    private String currency;
    private String exchangeFullName;
    private String exchange;
}
