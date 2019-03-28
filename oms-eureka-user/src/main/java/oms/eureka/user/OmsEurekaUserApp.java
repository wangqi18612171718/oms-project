package oms.eureka.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户模块
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class OmsEurekaUserApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(OmsEurekaUserApp.class).web(true).run(args);
	}
}
