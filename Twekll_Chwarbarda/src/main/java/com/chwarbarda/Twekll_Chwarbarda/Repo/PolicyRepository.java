package com.chwarbarda.Twekll_Chwarbarda.Repo;

import com.chwarbarda.Twekll_Chwarbarda.models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // Additional custom methods can be added if needed
}
