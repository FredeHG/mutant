package com.example.mutant.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${app.version}")
    private String appVersion;

    @RequestMapping(value = "/")
    public Map<String, String> APIstatus() {
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "OK");
        response.put("version", appVersion);
        return response;
    }

}
