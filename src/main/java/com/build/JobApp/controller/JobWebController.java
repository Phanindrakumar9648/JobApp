package com.build.JobApp.controller;

import com.build.JobApp.Domain.Job;
import com.build.JobApp.dao.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobWebController {

    @Autowired
    private JobRepo jobRepo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJobForm() {
        return "addjob";
    }

    @PostMapping("/submitjob")
    public String submitJob(
                            @RequestParam String title,
                            @RequestParam String description,
                            Model model) {
        Job job = new Job(title, description);
        Job savedJob = jobRepo.save(job);
        model.addAttribute("id", savedJob.getId());
        model.addAttribute("title", savedJob.getTitle());
        model.addAttribute("description", savedJob.getDescription());
        return "success";
    }

    @GetMapping("/viewjobs")
    public String viewJobs(Model model) {
        List<Job> jobs = jobRepo.findAll(); // Load from database
        model.addAttribute("jobs", jobs);
        return "viewalljobs";
    }


}
