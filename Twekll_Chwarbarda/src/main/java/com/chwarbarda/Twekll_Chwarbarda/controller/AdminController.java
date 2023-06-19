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
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/admin")
public class AdminController {
    private final ServicePostRepository servicePostRepository;
    private final ProjectRepository projectRepository;
    private final PolicyRepository policyRepository;
    private final CertificationsRepository certificationsRepository;

    @Autowired
    public AdminController(ServicePostRepository servicePostRepository, ProjectRepository projectRepository,
                           PolicyRepository policyRepository, CertificationsRepository certificationsRepository) {
        this.servicePostRepository = servicePostRepository;
        this.projectRepository = projectRepository;
        this.policyRepository = policyRepository;
        this.certificationsRepository = certificationsRepository;
    }

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



    // Mapping for Policy module
    @GetMapping("/adminpolicy")
    public String policyPage(Model model) {
        model.addAttribute("policy", new Policy());
        model.addAttribute("policies", policyRepository.findAll());
        return "adminpolicy";
    }


    // Mapping for Project module
    @GetMapping("/adminprojects")
    public String projectPage(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("projects", projectRepository.findAll());
        return "adminprojects";
    }



    // Mapping for Certifications module
    @GetMapping("/admincertification")
    public String certificationsPage(Model model) {
        model.addAttribute("certifications", new Certifications());
        model.addAttribute("certificationsList", certificationsRepository.findAll());
        return "admincertification";
    }

    @PostMapping("/addservices")
    public String addServicePost(@ModelAttribute ServicePost service) {
        servicePostRepository.save(service);
        return "redirect:/admin/adminservice";
    }

    // Mapping for Policy module


    @PostMapping("/addpolicies")
    public String createPolicy(@ModelAttribute Policy policy) {
        policyRepository.save(policy);
        return "redirect:/admin/adminpolicy";
    }







    @PostMapping("/addproject")
    public String addProject(@ModelAttribute Project project) {
        projectRepository.save(project);
        return "redirect:/admin/adminprojects";
    }



    @PostMapping("/addCertifications")
    public String createCertifications(@ModelAttribute Certifications certifications) {
        certificationsRepository.save(certifications);
        return "redirect:/admin/admincertification";
    }




}
