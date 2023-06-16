package com.chwarbarda.Twekll_Chwarbarda.Repo;

import com.chwarbarda.Twekll_Chwarbarda.models.ServicePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicePostRepository extends JpaRepository<ServicePost, Long> {
    ServicePost findById(long id);
}
