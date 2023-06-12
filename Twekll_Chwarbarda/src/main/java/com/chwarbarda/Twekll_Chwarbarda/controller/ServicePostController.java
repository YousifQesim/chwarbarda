package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ServicePostRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ServicePostController {
    @Autowired
    private ServicePostRepository servicePostRepository;


    public ServicePostController(ServicePostRepository servicePostRepository) {
        this.servicePostRepository = servicePostRepository;
    }

    @GetMapping("services")
    public List<ServicePost> getAllServicePosts() {
        return servicePostRepository.findAll();
    }
    @GetMapping("")
    public String welcome() {
        return "welcome sir";
    }
    @PostMapping("addservice")
    public ServicePost createServicePost(@RequestBody ServicePost servicePost) {
        return servicePostRepository.save(servicePost);
    }

    // Add other CRUD operations as needed
}