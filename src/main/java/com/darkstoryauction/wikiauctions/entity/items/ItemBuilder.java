package com.darkstoryauction.wikiauctions.entity.items;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Job;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Rarity;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Requirements;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemBuilder extends Item{
    private List<Rarity> rarityList;
    private Map<Requirements, Integer> requirementsMap;
    private Map<Stats, Integer> statsMap;
    private List<Job> jobList;
}
