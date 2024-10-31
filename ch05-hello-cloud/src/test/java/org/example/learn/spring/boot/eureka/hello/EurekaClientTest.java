package org.example.learn.spring.boot.eureka.hello;

import com.netflix.discovery.shared.Applications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EurekaClientTest {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired(required = false)
    private com.netflix.discovery.DiscoveryClient discoveryClient1;

    @Autowired
    private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient2;

    @Test
    public void test0() {
        System.out.println("eurekaClientClass = " + eurekaClient);
        System.out.println("discoveryClient1 = " + discoveryClient1);
        System.out.println("discoveryClient2 = " + discoveryClient2);

        Assertions.assertNotNull(eurekaClient);
        Assertions.assertNull(discoveryClient1);
        Assertions.assertNotNull(discoveryClient2);
    }

    @Test
    public void test1() {
        System.out.println("eurekaClientClass = " + eurekaClient);
        Assertions.assertNotNull(eurekaClient);

        Applications applications = eurekaClient.getApplications();
        System.out.println("applications = " + applications);
    }
}
