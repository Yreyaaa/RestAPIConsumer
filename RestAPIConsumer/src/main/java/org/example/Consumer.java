package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Consumer
{
    public static void main( String[] args )
    {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jasonToSend = new HashMap<>();
        jasonToSend.put("name","test name");
        jasonToSend.put("job","test job");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jasonToSend);

        String url = "https://reqres.in/api/usres/";
        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);
    }
}
