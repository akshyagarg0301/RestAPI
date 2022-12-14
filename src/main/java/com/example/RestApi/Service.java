package com.example.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private RestTemplate restTemplate;

    public String consumeAPI(String url)
    {
        return restTemplate.getForObject(url,String.class);
    }



}
