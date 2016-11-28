package uk.co.springworks.aws.hellocloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Created by pkuzan on 28/11/2016.
 */
public class PricerClient {
    RestTemplate restTemplate = new RestTemplate();

    private final String url;

    public PricerClient(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
