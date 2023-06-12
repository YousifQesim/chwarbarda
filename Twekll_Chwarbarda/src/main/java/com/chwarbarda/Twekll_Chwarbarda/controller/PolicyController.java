package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.PolicyRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PolicyController {
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyController(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @PostMapping("/addpolicies")
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }

    @GetMapping("/policies")
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
}
