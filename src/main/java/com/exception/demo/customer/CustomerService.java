package com.exception.demo.customer;

public interface CustomerService {
    Customer getCustomer(int id);
    String addCustomer(Customer customer);
    String updateCustomer(Customer customer);
}
