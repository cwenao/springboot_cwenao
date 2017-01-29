package com.bootcwenao.apigateway;

import com.bootcwenao.apigateway.filter.AccessSignFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
@EnableSidecar
public class ApiGatewayBootcwenaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayBootcwenaoApplication.class, args);
	}

	@Bean
	public AccessSignFilter accessSignFilter(){
		return new AccessSignFilter();
	}

}
