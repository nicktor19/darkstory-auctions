package com.darkstoryauction.wikiauctions.service.items.base.stats;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Bonus;
import com.darkstoryauction.wikiauctions.repository.items.base.stats.BonusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusService {
    @Autowired
    BonusRepo bonusRepo;

    public List<Bonus> getAllBonus() {
        return bonusRepo.findAll();
    }
    public String addBonus(Bonus bonus) {
        bonus.setName(DataNormalizer.upperCaseTitle(bonus.getName()));
        if (findBonus(bonus)) {
            bonusRepo.save(bonus);
            return bonus.getName() + " was created.";
        }
        return bonus.getName() + " was not created.";
    }

    public String delBonus(Bonus delBonus) {
        delBonus.setName(DataNormalizer.upperCaseTitle(delBonus.getName()));
        if (!findBonus(delBonus)) {
            bonusRepo.delete(delBonus);
            return delBonus.getName() + " was deleted.";
        } else {
            return delBonus.getName() + " does not exist.";
        }
    }

    public boolean findBonus(Bonus bonus) {
        return bonusRepo.findById(bonus.getName()).isEmpty();
    }
}
