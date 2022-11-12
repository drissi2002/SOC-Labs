package eni.app.ms_biling.services;

import eni.app.ms_biling.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="ms-product",url="http://localhost:8081")
public interface ProductServiceClient{

    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    List<Product> findAll();
}
