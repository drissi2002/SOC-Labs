package eni.app.ms_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
				.route(r -> r
						.path("/muslim/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host","muslimsalat.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key","4a637e7336msh845e52b4b12ae89p18aa31jsn461321ec909a")
								.rewritePath("/muslimsalat/(?<segment>.*)","/${segment}")
								.circuitBreaker(c->c.setName("muslim").setFallbackUri("forward:/defaultMuslim"))
						)
						.uri("https://muslimsalat.p.rapidapi.com")
				)
				.build();
	}
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}

}
