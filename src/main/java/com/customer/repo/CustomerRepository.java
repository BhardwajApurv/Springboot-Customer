package com.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.firstName LIKE %?1%"
		+ "OR c.lastName LIKE %?1%"	)
	public List<Customer> findAll(String keyword);
	
	

}
 