package com.spring.Validation.controller;

import com.spring.Validation.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/showForm")
    public String showForm(Model theModel) {

        // create a customer instance
        Customer theCustomer = new Customer();

        // add to the model attribute
        theModel.addAttribute("customer", theCustomer);

        return "showForm";
    }

   @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {

       System.out.println("Binding Results:" + " " + "|" +  theCustomer.getFirstName() + "|");
       System.out.println("|" + theCustomer.getLastName() + "|");
        if(theBindingResult.hasErrors()) {
            return "showForm";
        }

        return "processForm";
   }
}
