package com.CSC340.ClipzConnect;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.CSC340.ClipzConnect.entity.Customer;
import com.CSC340.ClipzConnect.service.CustomerService;

//UIController
@Controller
@RequestMapping("/customer")
public class CustomerUIController {
    
    private final CustomerService customerService;

    public CustomerUIController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {

        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isEmpty()) {
            return "error";
        }

        model.addAttribute("customer", customer.get());
        model.addAttribute("title", "Customer Profile");

        return "customer-profile";
    }

    @PostMapping("/update-basic/{id}")
    public String updateBasicInfo(@PathVariable Long id, Customer updatedCustomer, MultipartFile thumbnailFile){
        Customer customer = customerService.updateCustomer(id, updatedCustomer);
        if(customer != null){
            if(thumbnailFile != null && !thumbnailFile.isEmpty()){
                customerService.saveThumbnail(customer, thumbnailFile);
            }
            return "redirect:/customer/profile/" + customer.getId();
        }
        return "redirect:/customer/profile/" + id + "?error=true";
    }

    @PostMapping("/update-personal/{id}")
    public String updatePersonalInfo(@PathVariable Long id, Customer updatedCustomer, MultipartFile thumbnailFile){
        Customer customer = customerService.updatePersonalInfo(id, updatedCustomer);
        if(customer != null){
            if(thumbnailFile != null && !thumbnailFile.isEmpty()){
                customerService.saveThumbnail(customer, thumbnailFile);
            }
            return "redirect:/customer/profile/" + customer.getId();
        }
        return "redirect:/customer/profile/" + id + "?error=true";
    }

    @GetMapping("/updated-profile/{id}")
    public String showUpdatedCustomer(@PathVariable Long id, Model model) {

        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isEmpty()) {
            return "error";
        }

        model.addAttribute("customer", customer.get());
        model.addAttribute("title", "Update Customer");

        return "customer-profile";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable Long id, Model model){
        Optional<Customer> customer = customerService.getCustomerById(id);

        if (customer.isEmpty()) {
            return "error";
        }

        model.addAttribute("customer", customer.get());

        return "dashboard";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model){
        Optional<Customer> customer = customerService.checkLogin(email, password);
        
        if(customer.isPresent()){
            return "redirect:/customer/dashboard/" + customer.get().getId();
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/new")
    public String createCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle", "Create New Customer Profile");
        return "customer-signup";
    }

    @PostMapping("/save")
    public String createCustomer(Customer customer, MultipartFile thumbnailFile){
        Customer createdCustomer = customerService.createCustomer(customer);

        if(createdCustomer != null){
            if(thumbnailFile != null && !thumbnailFile.isEmpty()){
                customerService.saveThumbnail(createdCustomer, thumbnailFile);
            }
            return "redirect:/customer/dashboard/" + createdCustomer.getId();
        }
        return "redirect:/customer/new?error=true";
    }

    @GetMapping("/delete/{id}")
     public String deleteCustomer(@PathVariable Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);

        if(isDeleted){
            return "redirect:/index";
        }
        return "redirect:/index/" + id + "?error=true";
    }

}
