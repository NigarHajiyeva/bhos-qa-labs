package com.example.springproj2;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.*;
import java.util.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Springproj2ApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    public String url = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos";
    
    
    @Test
    @DisplayName("Integration Test to check SSL certificate")
	void test1() throws CertificateException, IOException {
		URL url = new URL(this.url);

		URLConnection con = url.openConnection();
		HttpsURLConnection securecon = (HttpsURLConnection) con;
		securecon.connect();

		Certificate[] certs = securecon.getServerCertificates();

		FileInputStream fis = new FileInputStream("mockapicert.cer");

		CertificateFactory fac = CertificateFactory.getInstance("X509");
		X509Certificate cert = (X509Certificate) fac.generateCertificate(fis);

		assertEquals(cert, certs[0]);
	}



    @Test
    @DisplayName("Integration test of 'https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos' link")
    public void firstURLTest() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        JSONArray objects = new JSONArray(response.getBody());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < objects.length(); i++) {
            JSONObject o = (JSONObject) objects.get(i);
            map.put(o.getString("id"), o.getString("name"));

        }
        assertThat(map).containsKey("1");

    }

}


