package com.learn.spring.springbootauthenticationwithjwt.service;

import com.learn.spring.springbootauthenticationwithjwt.entity.Job;
import com.learn.spring.springbootauthenticationwithjwt.exception.UserNotFoundException;
import com.learn.spring.springbootauthenticationwithjwt.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> findAllJob() {
        return jobRepository.findAll();
    }

    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    public Job findJobyId(Long id) {
        return jobRepository.findJobById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteJob(Long id){
        jobRepository.deleteJobById(id);
    }
}
