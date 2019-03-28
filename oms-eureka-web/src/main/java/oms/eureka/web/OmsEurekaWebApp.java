package oms.eureka.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OmsEurekaWebApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(OmsEurekaWebApp.class).web(true).run(args);
	}
}
