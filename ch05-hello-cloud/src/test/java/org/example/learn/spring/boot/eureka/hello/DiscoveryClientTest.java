package org.example.learn.spring.boot.eureka.hello;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryClientTest {

    private static final Logger logger = LoggerFactory.getLogger(DiscoveryClientTest.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test0() {
        List<String> services = discoveryClient.getServices();
        logger.info("services: {}", services);
    }
}
