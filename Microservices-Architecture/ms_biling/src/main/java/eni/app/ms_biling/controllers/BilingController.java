package eni.app.ms_biling.controllers;

import eni.app.ms_biling.entities.Biling;
import eni.app.ms_biling.entities.ProductItem;
import eni.app.ms_biling.repositories.BilingRepository;
import eni.app.ms_biling.repositories.ProductItemRepository;
import eni.app.ms_biling.services.CustomerServiceClient;
import eni.app.ms_biling.services.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

public class BilingController {
    @Autowired
    private BilingRepository bilingRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private ProductServiceClient productServiceClient;

    @GetMapping("/bills/full/{id}")
    Biling getBill(@PathVariable(name="id") Long id) {
        Biling bill = bilingRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach( pi->{
            pi.setProduct(productServiceClient.findProductById(pi.getProductID()));
        });
        return bill; }
}
