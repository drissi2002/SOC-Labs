package eni.app.ms_customer;

import eni.app.ms_customer.entities.Customer;
import eni.app.ms_customer.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MsCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){

		return args -> {

			customerRepository.save(new Customer(1L,"Ensi","contact@ensi-media.tn"));
			customerRepository.save(new Customer(2L,"Enit","contact@enit.tn"));
			customerRepository.save(new Customer(3L,"Enicar","contact@enicar.tn"));
			customerRepository.findAll().forEach(System.out::println);

		};

	}
}
