package com.CSC340.ClipzConnect;

import com.CSC340.ClipzConnect.entity.Barber;
import com.CSC340.ClipzConnect.entity.BarberService;
import com.CSC340.ClipzConnect.entity.Review;
import com.CSC340.ClipzConnect.entity.Timeslot;
import com.CSC340.ClipzConnect.service.BarberAccountService;
import com.CSC340.ClipzConnect.service.BarberServiceManager;
import com.CSC340.ClipzConnect.service.ReviewService;
import com.CSC340.ClipzConnect.service.TimeslotService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/barber")
public class BarberUIController {

    private final BarberAccountService barberAccountService;
    private final BarberServiceManager barberServiceManager;
    private final ReviewService        reviewService;
    private final TimeslotService      timeslotService;

    public BarberUIController(BarberAccountService barberAccountService,
                              BarberServiceManager barberServiceManager,
                              ReviewService        reviewService,
                              TimeslotService      timeslotService) {
        this.barberAccountService = barberAccountService;
        this.barberServiceManager = barberServiceManager;
        this.reviewService        = reviewService;
        this.timeslotService      = timeslotService;
    }

    //LOGIN / REGISTER 

    @GetMapping("/login")
    public String showLoginPage() {
        return "barber-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {
        Optional<Barber> barber = barberAccountService.checkLogin(email, password);
        if (barber.isPresent()) {
            return "redirect:/barber/dashboard/" + barber.get().getId();
        }
        model.addAttribute("error", "Invalid email or password.");
        return "barber-login";
    }

    @GetMapping("/new")
    public String showRegisterPage(Model model) {
        model.addAttribute("showRegister", true);
        return "barber-login";
    }

    @PostMapping("/save")
    public String registerBarber(Barber barber) {
        Barber created = barberAccountService.createBarber(barber);
        return (created != null)
                ? "redirect:/barber/dashboard/" + created.getId()
                : "redirect:/barber/new?error=true";
    }

    //DASHBOARD 

    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable Long id, Model model) {
        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";
        model.addAttribute("barber",    barber.get());
        model.addAttribute("timeslots", timeslotService.getTimeslotsByBarberId(id));
        return "barber-appointments";
    }

    // PROFILE 

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";
        model.addAttribute("barber", barber.get());
        return "barber-profile";
    }

    @PostMapping("/profile/update/{id}")
    public String updateProfile(@PathVariable Long id, Barber updatedBarber) {
        barberAccountService.updateBarber(id, updatedBarber);
        return "redirect:/barber/profile/" + id;
    }

    @GetMapping("/delete/{id}")
    public String deleteBarber(@PathVariable Long id) {
        barberAccountService.deleteBarber(id);
        return "redirect:/index";
    }

    // REVIEWS 

    @GetMapping("/reviews/{id}")
    public String showReviews(@PathVariable Long id, Model model) {
        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";
        model.addAttribute("barber",  barber.get());
        model.addAttribute("reviews", reviewService.getReviewsByBarberId(id));
        return "barber-reviews";
    }

    @PostMapping("/reviews/{reviewId}/reply/{barberId}")
    public String replyToReview(@PathVariable Long reviewId,
                                @PathVariable Long barberId,
                                @RequestParam String replyText) {
        Review review = reviewService.getReviewById(reviewId);
        if (review != null) {
            review.setReplyText(replyText);
            reviewService.updateReview(reviewId, review);
        }
        return "redirect:/barber/reviews/" + barberId;
    }

    @GetMapping("/reviews/{reviewId}/delete/{barberId}")
    public String deleteReview(@PathVariable Long reviewId,
                               @PathVariable Long barberId) {
        reviewService.deleteReview(reviewId);
        return "redirect:/barber/reviews/" + barberId;
    }

    //  SERVICES 
    @GetMapping("/services/{id}")
    public String showServices(@PathVariable Long id, Model model) {
        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";
        model.addAttribute("barber",     barber.get());
        model.addAttribute("services",   barberServiceManager.getServicesByBarberId(id));
        model.addAttribute("newService", new BarberService());
        return "barber-services";
    }

    @PostMapping("/services/add/{id}")
    public String addService(@PathVariable Long id,
                             @RequestParam String  name,
                             @RequestParam String  description,
                             @RequestParam Double  price,
                             @RequestParam(required = false) Integer durationMinutes) {
        BarberService service = new BarberService();
        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);
        service.setDurationMinutes(durationMinutes);
        barberServiceManager.addService(id, service);
        return "redirect:/barber/services/" + id;
    }

    @PostMapping("/services/update/{serviceId}/{barberId}")
    public String updateService(@PathVariable Long   serviceId,
                                @PathVariable Long   barberId,
                                @RequestParam String  name,
                                @RequestParam String  description,
                                @RequestParam Double  price,
                                @RequestParam(required = false) Integer durationMinutes) {
        BarberService updated = new BarberService();
        updated.setName(name);
        updated.setDescription(description);
        updated.setPrice(price);
        updated.setDurationMinutes(durationMinutes);
        barberServiceManager.updateService(serviceId, updated);
        return "redirect:/barber/services/" + barberId;
    }

    @GetMapping("/services/delete/{serviceId}/{barberId}")
    public String deleteService(@PathVariable Long serviceId,
                                @PathVariable Long barberId) {
        barberServiceManager.deleteService(serviceId);
        return "redirect:/barber/services/" + barberId;
    }

    // ── APPOINTMENTS + TIMESLOTS ──────────────────────────────────────────

    @GetMapping("/appointments/{id}")
    public String showAppointments(@PathVariable Long id, Model model) {
        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";
        model.addAttribute("barber",    barber.get());
        model.addAttribute("timeslots", timeslotService.getTimeslotsByBarberId(id));
        return "barber-appointments";
    }

    @PostMapping("/timeslots/add/{id}")
    public String addTimeslot(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime endTime) {

        Optional<Barber> barber = barberAccountService.getBarberById(id);
        if (barber.isEmpty()) return "error";

        Timeslot slot = new Timeslot();
        slot.setBarber(barber.get());
        slot.setStartTime(startTime);
        slot.setEndTime(endTime);
        slot.setIsAvailable(true);
        timeslotService.createTimeslot(slot);
        return "redirect:/barber/appointments/" + id;
    }

    @GetMapping("/timeslots/delete/{timeslotId}/{barberId}")
    public String deleteTimeslot(@PathVariable Long timeslotId,
                                 @PathVariable Long barberId) {
        timeslotService.deleteTimeslot(timeslotId);
        return "redirect:/barber/appointments/" + barberId;
    }
}
