package com.learn.spring.springbootauthenticationwithjwt.controller;

import com.learn.spring.springbootauthenticationwithjwt.entity.Job;
import com.learn.spring.springbootauthenticationwithjwt.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJob () {
        List<Job> jobs = jobService.findAllJob();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Job> getJobById (@PathVariable("id") Long id) {
        Job job = jobService.findJobyId(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job newJob = jobService.addJob(job);
        return new ResponseEntity<>(newJob, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        Job updateJob = jobService.updateJob(job);
        return new ResponseEntity<>(updateJob, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
