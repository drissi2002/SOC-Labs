package eni.app.ms_product;

import eni.app.ms_product.entities.Product;
import eni.app.ms_product.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class MsProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null,"javel",6.5,4));
            productRepository.save(new Product(null,"omo",5.0,2));
            List<Product> allProducts = productRepository.findAll();
            System.out.println("All productss in DB: " + allProducts);
        };
    }
}
