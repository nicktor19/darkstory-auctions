package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.Stats;
import com.darkstoryauction.wikiauctions.repository.items.StatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    @Autowired
    StatsRepo statsRepo;

    public List<Stats> getAllStats() {
        return statsRepo.findAll();
    }

    public String addStats(Stats stat) {
        stat.setName(DataNormalizer.upperCaseWord(stat.getName()));
        if (findStat(stat)) {
            statsRepo.save(stat);
            return stat.getName() + " was created";
        } else {
            return stat.getName() + " could not be created.";
        }
    }

    //check
    public boolean findStat(Stats stat) {
        return  statsRepo.findById(stat.getName()).isEmpty();
    }
    //delete
    public String deleteStat(Stats stat) {
        stat.setName(DataNormalizer.upperCaseWord(stat.getName()));
        if (!findStat(stat)) {
            statsRepo.deleteById(stat.getName());
            return stat.getName() + " was deleted.";
        } else {
            return stat.getName() + " does not exist.";
        }
    }
}
