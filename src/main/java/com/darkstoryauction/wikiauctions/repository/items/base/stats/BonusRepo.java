package com.darkstoryauction.wikiauctions.repository.items.base.stats;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepo extends JpaRepository<Bonus, String> {
}
