package oms.eureka.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 用户模块
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@EnableRedisHttpSession
public class OmsEurekaUserApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(OmsEurekaUserApp.class).web(true).run(args);
	}
}
