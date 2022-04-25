package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customerList = customerService.getCustomer();
		
		theModel.addAttribute("customerList",customerList);
		
		return "list-customers";
	}
	
	@GetMapping(path = "/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping(path = "/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers/list";
	}
	
	@GetMapping(path = "/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model) {
		
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@GetMapping(path = "/delete")
	public String deleteCustomer(@RequestParam("customerId") int id,Model model) {
		
		 customerService.deleteCustomer(id);
		
		 return "redirect:/customers/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		System.out.println("In");
        List<Customer> customerList = customerService.searchCustomers(theSearchName);
        theModel.addAttribute("customerList", customerList);
        return "list-customers";        
    }

}
