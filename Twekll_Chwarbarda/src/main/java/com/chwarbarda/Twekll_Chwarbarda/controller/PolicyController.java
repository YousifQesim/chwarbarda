package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.PolicyRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PolicyController {
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyController(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @PostMapping("/addpolicies")
    public String addProduct(@ModelAttribute("policy") Policy policy) {
        policyRepository.save(policy);
        return "redirect:/admin/policy";
    }

    @GetMapping("/policy")
    public String getAllPolicies(Model model) {
        List<Policy> policies = policyRepository.findAll();
        model.addAttribute("policies", policies);
        return "policy";
    }

}
