package org.example.learn.spring.boot.eureka.hello;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MetaMapTest {

    private static final Logger logger = LoggerFactory.getLogger(MetaMapTest.class);

    // 当前instance的配置信息
    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test0() {
        logger.info("当前服务instance的配置信息: {}", eurekaInstanceConfig);

        String customKey1 = eurekaInstanceConfig.getMetadataMap().get("customKey1");
        String customKey2 = eurekaInstanceConfig.getMetadataMap().get("customKey2");
        logger.info("customKey1: {}", customKey1);
        logger.info("customKey2: {}", customKey2);
    }

    @Test
    public void test1() {
        List<String> serviceIds = discoveryClient.getServices();
        serviceIds.forEach(serviceId -> {
            logger.info("serviceId: {}", serviceId);
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            instances.forEach(instance -> {
                Map<String, String> metadata = instance.getMetadata();
                metadata.forEach((key, value) -> logger.info("metadata配置信息: {} -> {}", key, value));
            });
        });
    }
}
