package de.c24.finacc.klt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring boot application start point
 */
@SpringBootApplication
@EnableCaching
public class KltApplication {

    /**
     * start point
     *
     * @param args system arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(KltApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
