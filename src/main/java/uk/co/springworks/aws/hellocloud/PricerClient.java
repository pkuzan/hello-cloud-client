package uk.co.springworks.aws.hellocloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;

/**
 * Created by pkuzan on 28/11/2016.
 */
public class PricerClient {
    RestTemplate restTemplate = new RestTemplate();

    private final String url;

    public PricerClient(String url){
        this.url = url;
    }

    public ResponseEntity<Price> getPrice(String symbol){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Price> responseEntity = restTemplate.exchange("{url}/prices/{symbol}", HttpMethod.GET, entity, Price.class, url, symbol);

        return responseEntity;
    }


    public String getUrl() {
        return url;
    }
}
