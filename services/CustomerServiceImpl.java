package com.example.springmvc.services;

import com.example.springmvc.domain.Customer;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
       // loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    private Integer getNextId() {
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public Customer saveAndUpdateCustomer(Customer customer) {
        if(customer != null) {
            if(customer.getId() == null) {
                customer.setId(getNextId());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Customer can't be null!");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("john.doe@springcourse.com");
        customer1.setPhoneNumber("12345678");
        customer1.setAddress1("1st Spring street");
        customer1.setAddress2("Framework district");
        customer1.setCity("Spring Boot");
        customer1.setState("SB");
        customer1.setZip("1234");

        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Johny");
        customer2.setLastName("Doey");
        customer2.setEmail("johny.doey@springcourse.com");
        customer2.setPhoneNumber("87654321");
        customer2.setAddress1("2nd Spring street");
        customer2.setAddress2("Framework district");
        customer2.setCity("Spring Boot");
        customer2.setState("SB");
        customer2.setZip("4321");

        customers.put(2, customer1);
    }
}
