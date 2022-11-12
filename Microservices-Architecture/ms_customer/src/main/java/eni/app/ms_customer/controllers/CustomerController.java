package eni.app.ms_customer.controllers;

import eni.app.ms_customer.entities.Customer;
import eni.app.ms_customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @RequestMapping(value="/customers",method= RequestMethod.GET)
    public List<Customer> customers(){

        return customerRepository. findAll();

    }

    @RequestMapping(value="/customers/{id}",method= RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") Long id){
        return customerRepository.getById(id);
    }

    @RequestMapping(value="/customers",method=RequestMethod.POST)
    public Customer save(@RequestBody Customer c){

        return customerRepository.save(c);

    }

}
