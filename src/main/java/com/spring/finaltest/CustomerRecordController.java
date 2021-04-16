package com.spring.finaltest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerRecordController {

	@Autowired 
	private CustomerRecordRepository cusRecordRepository;
	
	@GetMapping("/")
	public String index(Model model) { 
		 model.addAttribute("customers", cusRecordRepository.findAll());
	     return "index";
	}
	
	//To get the add-customer.html page	
	@RequestMapping(value = "/customer", method = RequestMethod.GET) 
	public String home(Model model) { 
	    model.addAttribute("customer", new CustomerRecord()); 
	    return "add-customer"; 
	}
	
	//add the customer info
	@PostMapping("/add")
    public String add(@Valid CustomerRecord customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-customer";
        }

        cusRecordRepository.save(customer);
        model.addAttribute("customers", cusRecordRepository.findAll());
        return "index";
    }
	
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    CustomerRecord customer = cusRecordRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid customer number:" + no));

	    model.addAttribute("customer", customer);
	    return "update-customer";
	}
	
	//update the existing customer info
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid CustomerRecord customer,
	  BindingResult result, Model model) {
        customer.setCustomerId(no);

	    if (result.hasErrors()) {
	        return "update-customer";
	    }
	    
	    cusRecordRepository.save(customer);
	    model.addAttribute("customers", cusRecordRepository.findAll());
	    return "index";
	}
	
	//delete a customer info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    CustomerRecord customer = cusRecordRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid customer Number:" + no));
	    cusRecordRepository.delete(customer);
	    model.addAttribute("customers", cusRecordRepository.findAll());
	    return "index";
	}
	
}
