package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.entity.items.Rarity;
import com.darkstoryauction.wikiauctions.repository.items.RarityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RarityService {
    @Autowired
    RarityRepo rarityRepo;

    public String addRarity(Rarity newRarity){
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
