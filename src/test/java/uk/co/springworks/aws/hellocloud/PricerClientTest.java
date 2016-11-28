package uk.co.springworks.aws.hellocloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by pkuzan on 28/11/2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PricerClientConfig.class)
public class PricerClientTest {
    @Value("#{pricerClient}")
    private PricerClient pricerClient;

    @Test
    public void getPrice() {
        System.err.println(pricerClient.getUrl());
    }
}
