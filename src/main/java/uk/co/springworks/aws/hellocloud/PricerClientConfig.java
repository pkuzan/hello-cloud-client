package uk.co.springworks.aws.hellocloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by pkuzan on 28/11/2016.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PricerClientConfig {
    @Value("${server.url}")
    public String url;

    @Bean
    public PricerClient pricerClient(){
        return new PricerClient(url);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
