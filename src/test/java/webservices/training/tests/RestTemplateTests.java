package webservices.training.tests;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RestTemplateTests {

    @Test
    public void checkStatusCode() {
        org.springframework.web.client.RestTemplate restTeample = new org.springframework.web.client.RestTemplate();
        ResponseEntity<Object[]> response = restTeample.getForEntity("https://jsonplaceholder.typicode.com/users", Object[].class);
        int actStatusCode = response.getStatusCode().value();
        Assert.assertEquals(actStatusCode, 200);
    }

    @Test
    public void checkResponseHeader() {
        org.springframework.web.client.RestTemplate restTeample = new org.springframework.web.client.RestTemplate();
        ResponseEntity<Object[]> response = restTeample.getForEntity("https://jsonplaceholder.typicode.com/users", Object[].class);
        HttpHeaders headers = response.getHeaders();

        String actContentTypeValue = headers.getContentType().toString();
        Assert.assertEquals(actContentTypeValue, "application/json;charset=utf-8");
    }

    @Test()
    public void checkResponseBody() {
        org.springframework.web.client.RestTemplate restTeample = new org.springframework.web.client.RestTemplate();
        ResponseEntity<Object[]> response = restTeample.getForEntity("https://jsonplaceholder.typicode.com/users", Object[].class);
        Object[] actPosts = response.getBody();
        Assert.assertEquals(actPosts.length, 10);
    }


}
