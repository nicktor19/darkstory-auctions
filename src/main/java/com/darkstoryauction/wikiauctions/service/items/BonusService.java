package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.entity.items.Bonus;
import com.darkstoryauction.wikiauctions.repository.items.BonusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusService {
    @Autowired
    BonusRepo bonusRepo;

    public String addBonus(Bonus bonus) {
        if (findItemType(bonus)) {
            bonusRepo.save(bonus);
            return bonus.getName() + " was created";
        }
        return bonus.getName() + " was not created";
    }

    public boolean findItemType(Bonus bonus) {
        return bonusRepo.findById(bonus.getName()).isEmpty();
    }
}
