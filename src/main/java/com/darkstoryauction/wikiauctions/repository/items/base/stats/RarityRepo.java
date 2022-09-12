package com.darkstoryauction.wikiauctions.repository.items.base.stats;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RarityRepo extends JpaRepository<Rarity, String> {
}
