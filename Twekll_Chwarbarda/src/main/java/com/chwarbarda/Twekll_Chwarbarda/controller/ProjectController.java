package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.ProjectRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/projects")
    public String getAllProjectsinProject(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/projects/{id}")
    public String getProjectsById(@PathVariable Long id, Model model) {
        Project projects = projectRepository.findById(id).orElse(null);
        model.addAttribute("projects", projects);
        return "projects";
    }


    @PostMapping("/addprojects")
    public String AddProjects(@ModelAttribute Project projects) {
        projectRepository.save(projects);
        return "redirect:/admin/adminprojects";
    }



}
