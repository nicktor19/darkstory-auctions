package com.darkstoryauction.wikiauctions.repository.items;

import com.darkstoryauction.wikiauctions.entity.items.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepo extends JpaRepository<Bonus, String> {
}
