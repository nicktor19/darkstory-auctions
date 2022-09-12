package com.darkstoryauction.wikiauctions.repository.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStatsRepo extends JpaRepository<ItemStats, Integer> {
}
