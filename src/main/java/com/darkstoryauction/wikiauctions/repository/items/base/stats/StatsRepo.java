package com.darkstoryauction.wikiauctions.repository.items.base.stats;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepo extends JpaRepository<Stats, String> {
}
