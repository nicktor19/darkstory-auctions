package com.darkstoryauction.wikiauctions.service.items.base.stats;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Job;
import com.darkstoryauction.wikiauctions.repository.items.base.stats.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;

    public List<Job> getAllJobs() {
            return jobRepo.findAll();
    }

    public String addJob(Job newJob){
        newJob.setName(DataNormalizer.upperCaseTitle(newJob.getName()));
        if (findJob(newJob)) {
            jobRepo.save(newJob);
            return newJob.getName() + " was created.";
        } else {
            return newJob.getName() + " was not created.";
        }
    }

    public String delJob(Job delJob) {
        delJob.setName(DataNormalizer.upperCaseTitle(delJob.getName()));
        if (!findJob(delJob)) {
            jobRepo.delete(delJob);
            return delJob.getName() + " was deleted";
        } else {
            return delJob.getName() + " does not exist.";
        }
    }

    public boolean findJob(Job job){
        return jobRepo.findById(job.getName()).isEmpty();
    }
}
