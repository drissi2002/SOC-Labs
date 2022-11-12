package eni.app.ms_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGatewayApplication.class, args);
	}
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route("ms-customer",r->r.path("/customers/**").uri("lb://ms-customer"))
				.route("ms-product",r->r.path("/products/**").uri("lb://ms-product"))
				.route("ms-biling",r->r.path("/bilings/**").uri("lb://ms-biling"))
				.build();
	}

}
