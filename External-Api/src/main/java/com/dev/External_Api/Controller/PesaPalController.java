package com.dev.External_Api.Controller;

import com.dev.External_Api.Model.PesaPalResponse;
import com.dev.External_Api.Service.PesaPalAccessToken;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PesaPalController {
    private final PesaPalAccessToken pesaPalAccessToken;
    public PesaPalController(PesaPalAccessToken pesaPalAccessToken){
        this.pesaPalAccessToken = pesaPalAccessToken;

    }
    @Tag(name = "Generate token")
    @PostMapping("/token")
    public PesaPalResponse pesaPalAccessTokenModel(){
        return pesaPalAccessToken.getAccessToken();
    }


}
