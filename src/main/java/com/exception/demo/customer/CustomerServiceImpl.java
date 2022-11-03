package com.exception.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
        if(customer1 == null){
            customerRepository.save(customer);
            return "Customer with ID " + customer.getId() + " added successfully!!";
        }
        else {
            throw new CustomerAlreadyExistsException("Customer with ID " + customer.getId() + " already exist");
        }
    }

    @Override
    public String updateCustomer(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
        if(customer1 == null){
            throw new NoSuchCustomerExistsException("No such Customer exist with ID " +customer.getId());
        }
       else {
           customer1.setName(customer.getName());
           customer1.setAddress(customer.getAddress());
           customerRepository.save(customer1);
           return "Record for ID " + customer.getId() + "updated successfully";
        }
    }
    public Customer getCustomer(int id)
    {
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchCustomerExistsException(
                        "NO CUSTOMER PRESENT WITH ID = " + id));
    }
}
