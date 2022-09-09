package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.Bonus;
import com.darkstoryauction.wikiauctions.repository.items.BonusRepo;
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
        bonus.setName(DataNormalizer.upperCaseWord(bonus.getName()));
        if (findBonus(bonus)) {
            bonusRepo.save(bonus);
            return bonus.getName() + " was created.";
        }
        return bonus.getName() + " was not created.";
    }

    public String delBonus(Bonus delBonus) {
        delBonus.setName(DataNormalizer.upperCaseWord(delBonus.getName()));
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
