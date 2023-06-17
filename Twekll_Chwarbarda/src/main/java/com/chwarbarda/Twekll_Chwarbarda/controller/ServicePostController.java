package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ServicePostRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller



public class ServicePostController {
    @Autowired
    private ServicePostRepository servicePostRepository;



    public ServicePostController(ServicePostRepository servicePostRepository) {
        this.servicePostRepository = servicePostRepository;
    }

    @GetMapping("/services")
    public List<ServicePost> getAllServicePosts() {
        return servicePostRepository.findAll();
    }



    @GetMapping("/")
    public String getAllServicePostsInIndex(Model model) {
        List<ServicePost> servicePosts = servicePostRepository.findAll();
        model.addAttribute("servicePosts", servicePosts);
        return "index";
    }
    @GetMapping("/service")
    public String getAllServicePostsInService(Model model) {
        List<ServicePost> servicePosts = servicePostRepository.findAll();
        model.addAttribute("servicePosts", servicePosts);
        return "service";
    }

    @GetMapping("/service/{id}")
    public String getServicePostDetails(@PathVariable Long id, Model model) {
        ServicePost servicePost = servicePostRepository.findById(id).orElse(null);
        model.addAttribute("servicePost", servicePost);
        return "servicePostDetails";
    }

    @PostMapping("/addservice")
    public ServicePost ServicePost(@ModelAttribute ServicePost servicePost) {
       return servicePostRepository.save(servicePost);
    // Redirect to the admin page after submitting the form
    }










    // Add other CRUD operations as needed
}