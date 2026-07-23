package com.CSC340.ClipzConnect.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CSC340.ClipzConnect.entity.Customer;
import com.CSC340.ClipzConnect.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

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
            customer.setFirstName(updatedCustomer.getFirstName());
            customer.setLastName(updatedCustomer.getLastName());
            customer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public Customer updatePersonalInfo(Long id, Customer updatedCustomer) {
    Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            if (updatedCustomer.getPhoneNumber() != null) {
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            }
            if (updatedCustomer.getPassword() != null) {
                customer.setPassword(updatedCustomer.getPassword());
            }
            if (updatedCustomer.getLocation() != null) {
                customer.setLocation(updatedCustomer.getLocation());
            }
            if (updatedCustomer.getAccountStatus() != null) {
                customer.setAccountStatus(updatedCustomer.getAccountStatus());
            }
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public boolean deleteCustomer(Long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public void saveThumbnail(Customer customer, MultipartFile thumbnailFile) {
        String originalFileName = thumbnailFile.getOriginalFilename();
        try {
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            String fileName = "customer" + customer.getId() + "." + fileExtension;
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            InputStream inputStream = thumbnailFile.getInputStream();

            Files.createDirectories(Paths.get(UPLOAD_DIR));
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            customer.setThumbnailUrl(fileName);
            customerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Customer> checkLogin(String email, String password) {

        Optional<Customer> customer = customerRepository.findByEmail(email);

        if (customer.isEmpty()) {
            return Optional.empty();
        }

        if (!customer.get().getPassword().equals(password)) {
            return Optional.empty();
        }

        return customer;
    }
}
