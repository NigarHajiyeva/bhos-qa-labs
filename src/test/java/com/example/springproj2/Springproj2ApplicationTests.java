package com.example.springproj2;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Springproj2ApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


    @Test
    @DisplayName("Integration test of 'https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos' link")
    public void firstURLTest() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos", HttpMethod.GET, entity, String.class);

        JSONArray objects = new JSONArray(response.getBody());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < objects.length(); i++) {
            JSONObject o = (JSONObject) objects.get(i);
            map.put(o.getString("id"), o.getString("name"));

        }
        assertThat(map).containsKey("1");

    }

}


