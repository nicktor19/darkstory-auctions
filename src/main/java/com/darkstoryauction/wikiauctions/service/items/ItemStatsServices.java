package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.entity.items.Item;
import com.darkstoryauction.wikiauctions.entity.items.ItemStats;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import com.darkstoryauction.wikiauctions.repository.items.ItemStatsRepo;
import com.darkstoryauction.wikiauctions.service.items.base.stats.StatsService;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItemStatsServices {
    @Autowired
    ItemStatsRepo itemStatsRepo;

    @Autowired
    StatsService statsService;

    /**
     * Takes the Item and saves the ID and takes the map of stats.
     * @param itemId
     * @param itemStatsMap
     * @return boolean
     */
    public boolean addItemStats(Item itemId, Map<Stats, Integer> itemStatsMap) {
        // save item into a list and save them all.
        List<ItemStats> itemStatsList = new ArrayList<>();
        System.out.println(itemStatsMap.keySet());
        itemStatsMap.forEach((stats, integer) -> itemStatsList.add(new ItemStats(0, itemId, stats, integer)));
        try{
            List<ItemStats> i = itemStatsRepo.saveAll(itemStatsList);
            System.out.println(i);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean statExist(Map<Stats, Integer> itemStatsMap) {
        List<Stats> allStats = statsService.getAllStats();
        for (Stats stat : itemStatsMap.keySet()) {
            if (!allStats.contains(stat)) {
                return false;
            }
        }
        return true;
    }
}


//        List<Stats> statsList = new StatsService().getAllStats();
//        int flag = 0;
//        for (Stats stat: statsList) {
//            for (ItemStats itemStats : ) {
//                itemStats.setId(itemId);
//                if (itemStats.getStats().equals(stat)) {
//                    itemStats.setStats(stat);
//                    flag++;
//                }
//            }
//        }
//        if (flag == itemStatsList.size()){
//            itemStatsRepo.saveAll(itemStatsList);
//            return true;
//        }
//        return false;