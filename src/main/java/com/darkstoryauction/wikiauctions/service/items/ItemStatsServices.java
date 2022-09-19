package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemStats;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import com.darkstoryauction.wikiauctions.repository.items.ItemStatsRepo;
import com.darkstoryauction.wikiauctions.service.items.base.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemStatsServices {
    @Autowired
    ItemStatsRepo itemStatsRepo;
    public boolean addItemStats(List<ItemStats> itemStatsList, int itemId) {
        List<Stats> statsList= new StatsService().getAllStats();
        int flag = 0;
        for (Stats stat: statsList) {
            for (ItemStats itemStats : itemStatsList) {
                itemStats.setId(itemId);
                if (itemStats.getStats().equals(stat)) {
                    itemStats.setStats(stat);
                    flag++;
                }
            }
        }
        if (flag == itemStatsList.size()){
            itemStatsRepo.saveAll(itemStatsList);
            return true;
        }
        return false;
    }

}
