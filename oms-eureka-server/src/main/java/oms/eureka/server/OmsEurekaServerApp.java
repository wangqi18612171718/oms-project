package oms.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * SpringCloud注册中心
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class OmsEurekaServerApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(OmsEurekaServerApp.class).web(true).run(args);
	}
}
