package com.chwarbarda.Twekll_Chwarbarda.Repo;

import com.chwarbarda.Twekll_Chwarbarda.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional custom methods can be added if needed
}
