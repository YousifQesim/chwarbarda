package com.chwarbarda.Twekll_Chwarbarda.Repo;

import com.chwarbarda.Twekll_Chwarbarda.models.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationsRepository extends JpaRepository<Certifications, Long> {
    // Additional custom methods can be added if needed
}