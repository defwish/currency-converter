package de.c24.finacc.klt;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    private final RestTemplate restTemplate;

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String get(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }
}
