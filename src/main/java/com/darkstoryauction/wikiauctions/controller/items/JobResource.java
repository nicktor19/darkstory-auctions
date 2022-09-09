package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Job;
import com.darkstoryauction.wikiauctions.service.items.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/job")
public class JobResource {
    private JobService jobService;

    @GetMapping("/get")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/add")
    public String addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @DeleteMapping("/delete")
    public String delJob(@RequestBody Job job) {
        return jobService.delJob(job);
    }
}
