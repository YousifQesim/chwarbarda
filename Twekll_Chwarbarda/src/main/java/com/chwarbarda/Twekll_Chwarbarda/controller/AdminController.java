package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.CertificationsRepository;
import com.chwarbarda.Twekll_Chwarbarda.Repo.PolicyRepository;
import com.chwarbarda.Twekll_Chwarbarda.Repo.ProjectRepository;
import com.chwarbarda.Twekll_Chwarbarda.Repo.ServicePostRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Certifications;
import com.chwarbarda.Twekll_Chwarbarda.models.Policy;
import com.chwarbarda.Twekll_Chwarbarda.models.Project;
import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ServicePostRepository servicePostRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CertificationsRepository certificationsRepository;


    @GetMapping("")
    public String admin() {
        return "admin";
    }
    // Mapping for ServicePost module
    @GetMapping("/adminservice")
    public String servicePostPage(Model model) {
        model.addAttribute("servicePost", new ServicePost());
        model.addAttribute("servicePosts", servicePostRepository.findAll());
        return "adminservice";
    }

    @PostMapping("/addservice")
    public String addServicePost(@ModelAttribute ServicePost servicePost) {
        servicePostRepository.save(servicePost);
        return "redirect:/admin/adminservice";
    }

    // Mapping for Policy module
    @GetMapping("/adminpolicy")
    public String policyPage(Model model) {
        model.addAttribute("policy", new Policy());
        model.addAttribute("policies", policyRepository.findAll());
        return "adminpolicy";
    }

    @PostMapping("/addpolicies")
    public String addPolicy(@ModelAttribute Policy policy) {
        policyRepository.save(policy);
        return "redirect:/admin/adminpolicy";
    }


    // Mapping for Project module
    @GetMapping("/project")
    public String projectPage(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("projects", projectRepository.findAll());
        return "project";
    }

    @PostMapping("/project/add")
    public String addProject(@ModelAttribute Project project) {
        projectRepository.save(project);
        return "redirect:/";
    }



    // Mapping for Certifications module
    @GetMapping("/admincertification")
    public String certificationsPage(Model model) {
        model.addAttribute("certifications", new Certifications());
        model.addAttribute("certifications", certificationsRepository.findAll());
        return "admincertification";
    }

    @PostMapping("/certifications/add")
    public String addCertifications(@ModelAttribute Certifications certifications) {
        certificationsRepository.save(certifications);
        return "redirect:/admin/admincertification";
    }
}
