package com.CSC340.ClipzConnect;

import java.util.List;
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
import com.CSC340.ClipzConnect.entity.HairAppointment;
import com.CSC340.ClipzConnect.entity.Review;
import com.CSC340.ClipzConnect.service.CustomerService;
import com.CSC340.ClipzConnect.service.HairAppointmentService;
import com.CSC340.ClipzConnect.service.ReviewService;
import com.CSC340.ClipzConnect.service.TimeslotService;

//UIController
@Controller
@RequestMapping("/customer")
public class CustomerUIController {
    
    private final CustomerService customerService;

    private final TimeslotService timeslotService;

    private final ReviewService reviewService;

    private final HairAppointmentService hairAppointmentService;

    public CustomerUIController(CustomerService customerService, TimeslotService timeslotService, ReviewService reviewService
        , HairAppointmentService hairAppointmentService){
        this.customerService = customerService;
        this.timeslotService = timeslotService;
        this.reviewService = reviewService;
        this.hairAppointmentService = hairAppointmentService;
    }

    //Customer User Story 1 Create/modify customer profile - Register as a customer
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

        return "customer-dashboard";
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
    //Customer User Story 4 Search/filter through available barbers - Browse suitable barbers through filters
    //Customer timeslot controller
    @GetMapping("/available")
    public String filterByAvailableTimeslots(Model model) {
        model.addAttribute("timeSlots", timeslotService.getAvailableTimeslots());

        model.addAttribute("pageTitle", "Available Timeslots");

        return "customer-book-appoint";
    }



    //Customer User Story 5 Write Reviews - Leave feedback on their experience
    //Customer appointment history page
    @GetMapping("/appointment/{customerId}")
    public String getAppointmentHistory(@PathVariable Long id, Model model){
        List<HairAppointment> history = hairAppointmentService.getAppointmentsByCustomerId(id);

        model.addAttribute("appointments", history);
        
        return "customer-appoint-history";
    }

    //Customer leave a review
    @PostMapping("/review/{customerId}")
    public String leaveReview(@PathVariable Long id, Review review, Model model){
        reviewService.createReview(review);

        model.addAttribute("review", reviewService.getReviewsByCustomerId(id));

        return "customer-appoint-history";
    }

    //Customer update a review
    @PostMapping("/review/update/{customerId}")
    public String updateReview(@PathVariable Long customerId, Review updatedReview, Model model){
        Review review = reviewService.getReviewById(updatedReview.getId());
        
        if(review != null){
            reviewService.updateReview(updatedReview.getId(), updatedReview);
            return "redirect:/customer/customer-appoint-history/" + customerId;
        }

        return "redirect:/customer/" + customerId + "?error=true";
    }

    //Customer delete a review
    @GetMapping("/review/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(reviewId);

        if(isDeleted){
            return "redirect:/customer/customer-appoint-history";
        }

        return "redirect:/customer/customer-appoint-history?error=true";
    }

    //Customer User Story 3 Book appointments - Schedule an appointment with a selected barber
    
}
