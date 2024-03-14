package com.infnet.ghproperty.controller;

import com.infnet.ghproperty.dto.PropertyDTO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Component
public class PropertyControllerTest {

    private final static String url = "http://localhost:8080/api/properties";

    @Autowired
    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    public ResponseEntity<String> save(PropertyDTO propertyDTO, String accessToken) throws Exception {
        HttpHeaders headers = getHeaderWithBearerToken(accessToken);

        RequestEntity<PropertyDTO> requestEntity = RequestEntity
                .post(new URI(url))
                .headers(headers)
                .body(propertyDTO);
        return testRestTemplate.exchange(requestEntity, String.class);
    }

    public ResponseEntity<String> getList(String accessToken) throws Exception {
        HttpHeaders headers = getHeaderWithBearerToken(accessToken);

        RequestEntity<Void> requestEntity = RequestEntity
                .get(new URI(url))
                .headers(headers)
                .build();
        return testRestTemplate.exchange(requestEntity, String.class);
    }

    private HttpHeaders getHeaderWithBearerToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        return headers;
    }
}
