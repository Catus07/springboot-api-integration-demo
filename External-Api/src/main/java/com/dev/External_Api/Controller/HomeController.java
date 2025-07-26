package com.dev.External_Api.Controller;

import com.dev.External_Api.Model.*;
import com.dev.External_Api.Service.FinancialService;
import com.dev.External_Api.Service.NewsServices;
import com.dev.External_Api.Service.RestClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private final RestClientService restClientService;
    private final NewsServices newsServices;
    private final FinancialService financialService;

    public HomeController(NewsServices newsServices, RestClientService restClientService,FinancialService financialService){
        this.newsServices = newsServices;
        this.restClientService = restClientService;
        this.financialService= financialService;
    }
    //JsonPlaceHolder Api
    @Tag(name="json placeholder",description = "this works with json placeholder api")
    @GetMapping("/resource")
    public JsonModel jsonModel(){
        return restClientService.getJsonModel();
    }

    @GetMapping("/listing")
    public List<JsonModel> jsonModel2(){
        return restClientService.externalApi2();
    }

    //newsAPI
    @Tag(name ="headline" ,description = "get topheadlines by country")
    @GetMapping("/prod/news/{country}")
    public NewsResponse newsTwo(@PathVariable String country){
        return newsServices.getTopHeadlines(country);
    }

    @Tag(name="headlines",description = "get top headlines by name trump")
    @GetMapping("/news/user/{name}")
    public TrumpNews getHeadlines(@PathVariable String name){
        return newsServices.topHeadlines(name);
    }

    @Tag(name="finance data", description = "get finance data")
    @GetMapping("/finance/data")
    public List<FinanceModel> getDetailsData(){
        return financialService.getFinancialData();
    }

    @Tag(name="search", description = "search finance symbol")
    @GetMapping("/finance/search")
    public List<SearchModel> searchSymbol(){
        return financialService.searchTickerSymbol();
    }
}
