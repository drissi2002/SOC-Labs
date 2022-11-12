package eni.app.ms_customer.repositories;

import eni.app.ms_customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CustomerRepository extends JpaRepository<Customer,Long> { }
