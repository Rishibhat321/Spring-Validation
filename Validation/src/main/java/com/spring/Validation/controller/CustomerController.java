package com.spring.Validation.controller;

import com.spring.Validation.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CustomerController {

    @GetMapping("/showForm")
    public String showForm(Model theModel) {

        // create a customer instance
        Customer theCustomer = new Customer();

        // add to the model attribute
        theModel.addAttribute("customer", theCustomer);

        return "index";
    }
}
