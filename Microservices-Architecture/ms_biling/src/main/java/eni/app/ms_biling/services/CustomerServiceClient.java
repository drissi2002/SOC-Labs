package eni.app.ms_biling.services;

import eni.app.ms_biling.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="ms-customer",url="http://localhost:8082")
public interface CustomerServiceClient{
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable("id") Long id);

}