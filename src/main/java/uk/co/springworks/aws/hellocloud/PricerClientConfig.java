package uk.co.springworks.aws.hellocloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by pkuzan on 28/11/2016.
 */
@Configuration
public class PricerClientConfig {
    @Value("${server.url}")
    public String url;

    @Bean
    public PricerClient pricerClient(){
        return new PricerClient(url);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application.properties"));
        return ppc;
    }
}
