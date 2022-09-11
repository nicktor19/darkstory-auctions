package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Stats;
import com.darkstoryauction.wikiauctions.service.items.StatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stats")
public class StatsResource {

    private StatsService statsService;

    @GetMapping("/get")
    public List<Stats> getAllStats() {
        return statsService.getAllStats();
    }

    @PostMapping("/add")
    public String addStat(@RequestBody Stats stat) {
        return statsService.addStats(stat);
    }

    @DeleteMapping("/delete")
    public String deleteStat(@RequestBody Stats stat) {
        return statsService.deleteStat(stat);
    }
}
