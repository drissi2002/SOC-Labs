package eni.app.ms_product.controllers;

import eni.app.ms_product.entities.Product;
import eni.app.ms_product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value="/products",method= RequestMethod.GET)
    public List<Product> products(){

        return productRepository. findAll();

    }

    @RequestMapping(value="/products",method=RequestMethod.POST)
    public Product save(@RequestBody Product p){

        return productRepository.save(p);

    }

}
