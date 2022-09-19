package com.darkstoryauction.wikiauctions.service.items.base.stats;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Requirements;
import com.darkstoryauction.wikiauctions.repository.items.base.stats.RequirementsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementsService {

    @Autowired
    RequirementsRepo requirementsRepo;

    public List<Requirements> getAllRequirements() {
        return requirementsRepo.findAll();
    }

    public String addRequirements(Requirements req) {
        req.setName(DataNormalizer.upperCaseTitle(req.getName()));
        if (findRequirement(req)) {
            requirementsRepo.save(req);
            return req.getName() + " was created.";
        } else {
            return req.getName() + " could not be created.";
        }
    }

    public String deleteRequirement(Requirements req) {
        req.setName(DataNormalizer.upperCaseTitle(req.getName()));
        if (!findRequirement(req)) {
            requirementsRepo.delete(req);
            return req.getName() + " was deleted.";
        } else {
            return req.getName() + " does not exist.";
        }
    }
    public boolean findRequirement(Requirements req) {
        return requirementsRepo.findById(req.getName()).isEmpty();
    }

}
