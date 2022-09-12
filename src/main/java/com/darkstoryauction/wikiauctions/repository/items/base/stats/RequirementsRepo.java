package com.darkstoryauction.wikiauctions.repository.items.base.stats;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsRepo extends JpaRepository<Requirements, String> {
}
