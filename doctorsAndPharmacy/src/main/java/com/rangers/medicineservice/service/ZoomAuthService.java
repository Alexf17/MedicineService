package com.rangers.medicineservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class ZoomAuthService {

    @Value("${zoom.client-id}")
    private String clientId;

    @Value("${zoom.account-id}")
    private String accountId;

    @Value("${zoom.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;

    public ZoomAuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientId, clientSecret);

        String requestBody = "";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        var response = restTemplate.postForEntity(
                "https://zoom.us/oauth/token?grant_type=account_credentials&account_id=" + accountId,
                request,
                Map.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return (String) Objects.requireNonNull(response.getBody()).get("access_token");
        } else {
            throw new RuntimeException("Failed to get Zoom access token");
        }
    }
}