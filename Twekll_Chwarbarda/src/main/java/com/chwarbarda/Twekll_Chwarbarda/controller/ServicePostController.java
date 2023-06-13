package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ServicePostRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String getAllServicePosts(Model model) {
        List<ServicePost> servicePosts = servicePostRepository.findAll();
        model.addAttribute("servicePosts", servicePosts);
        return "index";
    }



    @PostMapping("/addservice")
    public ServicePost createServicePost(@RequestBody ServicePost servicePost) {
        return servicePostRepository.save(servicePost);
    }












    // Add other CRUD operations as needed
}