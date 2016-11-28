package uk.co.springworks.aws.hellocloud;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by pkuzan on 28/11/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PricerClientConfig.class)
public class PricerClientTest {
    @Value("#{pricerClient}")
    private PricerClient pricerClient;

    @Test
    public void getPrice_whenFound() {
        String appleSymbol = "AAPL";
        String expectedApplePrice = "94.99";

        ResponseEntity<Price> responseEntity = pricerClient.getPrice(appleSymbol);

        Assert.assertEquals(expectedApplePrice, responseEntity.getBody().getPrice());
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getPrice_whenNotFound() {
        String appleSymbol = "FOO";

        try {
            pricerClient.getPrice(appleSymbol);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}
