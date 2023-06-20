package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ProjectRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    public String projectsPage(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }

    @GetMapping("/projects/{id}")
    public String getprojectDetail(@PathVariable Long id, Model model) {
        Project project = projectRepository.findById(id).orElse(null);
        model.addAttribute("project", project);
        return "projectDetail";
    }

}
