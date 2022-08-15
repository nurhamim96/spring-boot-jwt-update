package com.learn.spring.springbootauthenticationwithjwt.repository;

import com.learn.spring.springbootauthenticationwithjwt.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    void deleteJobById(Long id);
    Optional<Job> findJobById(Long id);
}
