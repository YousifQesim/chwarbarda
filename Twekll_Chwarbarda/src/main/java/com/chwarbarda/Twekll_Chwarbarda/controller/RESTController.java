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
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/admin")
public class RESTController {
    private final ServicePostRepository servicePostRepository;
    private final ProjectRepository projectRepository;
    private final PolicyRepository policyRepository;
    private final CertificationsRepository certificationsRepository;

    @Autowired
    public RESTController(ServicePostRepository servicePostRepository, ProjectRepository projectRepository,
                           PolicyRepository policyRepository, CertificationsRepository certificationsRepository) {
        this.servicePostRepository = servicePostRepository;
        this.projectRepository = projectRepository;
        this.policyRepository = policyRepository;
        this.certificationsRepository = certificationsRepository;
    }



    // Mapping for ServicePost module


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
