package com.darkstoryauction.wikiauctions.service.items.base.stats;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Rarity;
import com.darkstoryauction.wikiauctions.repository.items.base.stats.RarityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RarityService {
    @Autowired
    RarityRepo rarityRepo;

    public List<Rarity> getAllRarities() {
        return rarityRepo.findAll();
    }
    public String addRarity(Rarity newRarity){
        newRarity.setName(DataNormalizer.upperCaseWord(newRarity.getName()));
        if (findRarity(newRarity)) {
            rarityRepo.save(newRarity);
            return newRarity.getName() + " was created";
        }
        return newRarity.getName() + " was not created";
    }

    public String delRarity(Rarity rarity) {
        if (!findRarity(rarity)) {
            rarityRepo.delete(rarity);
            return rarity.getName() + " was delete.";
        } else {
            return rarity.getName() + " doesn't exist to delete";
        }

    }

    public boolean findRarity(Rarity rarity) {
        return rarityRepo.findById(rarity.getName()).isEmpty();
    }
}
