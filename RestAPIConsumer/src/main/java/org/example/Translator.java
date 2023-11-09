package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Введите тектс на русском языке");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","Bearer"+" t1.9euelZrLlMaanJidj5mQnM6YkZrNke3rnpWayY6cx5eYyZ3MmJ6clp2TmpPl8_diBW1Z-e9SXQ9u_d3z9yI0aln571JdD279zef1656Vmo-XzI7HnI2QmY-YjZaOxpmL7_zF656Vmo-XzI7HnI2QmY-YjZaOxpmL.MnNhKQSTAjjeKJiLzFPk6rtTZnifLzbrG9VK-URybwQTdzWfVKaj1oBQfG86WCiJ39EOhlPT26qla-u1WLK3Bg") ;
        Map<String, String > jsonData = new HashMap<>();
        jsonData.put("folderId", "b1gqf1bknp7hehgq5t1i");
        jsonData.put("targetLanguageCode","en");
        jsonData.put("texts","["+sentenceToTranslate+"]");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);


        YandexResponse response = restTemplate.postForObject(url, request, YandexResponse.class);

        System.out.println(response.getTranslations().get(0).getText());

    }
}