package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ProjectRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @PostMapping("/addprojects")
    public String saveProject(Project project) {
        projectRepository.save(project);
        return "redirect:/admin";
    }



@GetMapping("/getProjects")
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    // Other methods for retrieving, updating, or deleting projects
    // ...
}
