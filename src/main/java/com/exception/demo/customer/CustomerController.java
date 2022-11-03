package com.exception.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistException(CustomerAlreadyExistsException exception){
        return new ErrorResponse(HttpStatus.CONFLICT.value(),exception.getMessage());
    }
}
