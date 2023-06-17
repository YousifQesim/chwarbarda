package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ServicePostRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ServicePostRepository servicePostRepository;

    @GetMapping("")
    public String adminPage(Model model) {
        model.addAttribute("servicePost", new ServicePost());
        return "admin";
    }

    @PostMapping("/addservice")
    public String addServicePost(@ModelAttribute ServicePost servicePost) {
        servicePostRepository.save(servicePost);
        return "redirect:/admin";
    }
}
