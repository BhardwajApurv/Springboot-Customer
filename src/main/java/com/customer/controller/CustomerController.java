package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.entity.Customer;
import com.customer.repo.CustomerRepository;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerRepository repo;
	
	@GetMapping("/")
	public String search(Model model,@Param("keyword") String keyword)
	{
	
		List<Customer> listCustomer = service.listAll(keyword);
		
		model.addAttribute("listCustomer", listCustomer);
		
		
		
		return "search";
		
	}
	
	@GetMapping("/customer")
	public String createNewCustomer(Model model)
	{
		Customer customer = new Customer();
		 model.addAttribute("customer", customer);
		 
		return "customer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		repo.save(customer);
		
		return "redirect:/";
		
	}




}
