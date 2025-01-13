package com.spring.Validation.controller;

import com.spring.Validation.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

   @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {

        if(theBindingResult.hasErrors()) {
            return "showForm";
        }

        return "processForm";
   }
}
