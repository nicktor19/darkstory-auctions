package com.darkstoryauction.wikiauctions.entity.items;

import org.json.JSONObject;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemBuilder {
    private Item itemCore;
    private Map<Requirements, Integer> requirementsMap = new HashMap<>();
    private Map<Stats, Integer> statsMap = new HashMap<>();
    private List<Job> jobList = new ArrayList<>();

    /**
     * delete when finished. this is how to build the item
     * @param args
     */
    public static void main(String[] args) {
        ItemBuilder test = new ItemBuilder();
        Item newItem = new Item();

        newItem.setName("Billy");
        newItem.setType(new ItemType("Armor"));
        newItem.setRarity(new Rarity("Epic"));
        newItem.setPictureUrl("Google.com");

        Map<Requirements, Integer> reqMap = new HashMap<>();
        reqMap.put(new Requirements("Intelligence"), 100);
        reqMap.put(new Requirements("Strength"), 1000);

        Map<Stats, Integer> statsMap = new HashMap<>();
        statsMap.put(new Stats("Intelligence"), 200);
        statsMap.put(new Stats("Strength"), 2000);

        List<Job> jobList1 = new ArrayList<>();
        jobList1.add(new Job("NPC"));
        jobList1.add(new Job("Quester"));
        jobList1.add(new Job("Shop"));

        test.setItemCore(newItem);
        test.setRequirementsMap(reqMap);
        test.setStatsMap(statsMap);
        test.setJobList(jobList1);

        System.out.println();
    }
}
