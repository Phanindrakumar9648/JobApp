package com.build.JobApp.controller;

import com.build.JobApp.Domain.Job;
import com.build.JobApp.dao.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobs")
public class JobRestController {

    @Autowired
    private JobRepo repo;

    @PostMapping
    public Job createJob(@RequestBody Job job)
    {
        return repo.save(job);
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Integer id)
    {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @PutMapping("/{id}")
    public Job UpdateJob(@PathVariable Integer id, @RequestBody Job updatedJob)
    {
        Job job = repo.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        return repo.save(job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Integer id)
    {
        repo.deleteById(id);
        return "Job Delete Successfully";
    }
}

