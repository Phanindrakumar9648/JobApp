package com.build.JobApp.controller;

import com.build.JobApp.Domain.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController {

    private List<Job> jobList = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJobForm() {
        return "addjob";
    }

    @PostMapping("/submitJob")
    public String submitJob(@RequestParam String title,
                            @RequestParam String description,
                            Model model) {
        Job job = new Job(title, description);
        jobList.add(job);
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        return "success";
    }

    @GetMapping("/viewjobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", jobList);
        return "viewalljobs";
    }


}
