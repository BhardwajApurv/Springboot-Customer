package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	
	public List<Customer> listAll(String keyword)
	{
		if(keyword !=null)
		{
			return repo.findAll(keyword);
		}
		return repo.findAll();
		
	}
	
	
	
	
}
