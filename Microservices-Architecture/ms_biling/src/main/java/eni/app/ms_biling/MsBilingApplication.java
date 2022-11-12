package eni.app.ms_biling;

import eni.app.ms_biling.entities.Biling;
import eni.app.ms_biling.entities.Customer;
import eni.app.ms_biling.entities.ProductItem;
import eni.app.ms_biling.repositories.BilingRepository;
import eni.app.ms_biling.repositories.ProductItemRepository;
import eni.app.ms_biling.services.CustomerServiceClient;
import eni.app.ms_biling.services.ProductServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsBilingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBilingApplication.class, args);
	}
	@Bean
	public CommandLineRunner start(BilingRepository bilingRepository, ProductItemRepository productItemRepository, ProductServiceClient productServiceClient, CustomerServiceClient customerServiceClient){
		return args -> {
			Biling biling = new Biling();
			biling.setBillingDate(new Date());
			Long idCustomer = 1L ;
			Customer customer = customerServiceClient.findCustomerById(idCustomer);
			System.out.println(customer);
			try {
				biling.setCustomerID(idCustomer);
			}
			catch(NullPointerException e) {
				System.out.print("NullPointerException Caught");
			}
			bilingRepository.save(biling);
			System.out.println(biling);
			productServiceClient.findAll().forEach(p ->{
					productItemRepository.save(new ProductItem(null,null,p.getId(),p.getPrice(),(int)(1+Math.random()*1000),biling));
			});
		};
}
}
