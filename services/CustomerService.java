package com.example.springmvc.services;

import com.example.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveAndUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
