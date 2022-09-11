package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Requirements;
import com.darkstoryauction.wikiauctions.service.items.RequirementsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/requirements")
public class RequirementResource {

    private RequirementsService requirementsService;

    @GetMapping("/get")
    public List<Requirements> getAllRequirements() {
        return requirementsService.getAllRequirements();
    }

    @PostMapping("/add")
    public String addRequirements(@RequestBody Requirements req) {
        return requirementsService.addRequirements(req);
    }

    @DeleteMapping("/delete")
    public String deleteRequirements(@RequestBody Requirements req) {
        return requirementsService.deleteRequirement(req);
    }
}
