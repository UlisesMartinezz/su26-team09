package com.CSC340.ClipzConnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CSC340.ClipzConnect.entity.Customer;
import com.CSC340.ClipzConnect.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
    Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setAccountStatus(updatedCustomer.getAccountStatus());
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public Customer updatePersonalInfo(Long id, Customer updatedCustomer) {
    Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            if (updatedCustomer.getName() != null) {
                customer.setName(updatedCustomer.getName());
            }
            if (updatedCustomer.getPhoneNumber() != null) {
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            }
            if (updatedCustomer.getEmail() != null) {
                customer.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getLocation() != null) {
                customer.setLocation(updatedCustomer.getLocation());
            }
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
