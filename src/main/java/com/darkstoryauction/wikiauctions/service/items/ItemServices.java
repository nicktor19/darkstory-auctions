package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.Item;
import com.darkstoryauction.wikiauctions.entity.items.ItemBuilder;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Job;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Requirements;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import com.darkstoryauction.wikiauctions.repository.items.ItemRepo;
import com.darkstoryauction.wikiauctions.service.items.base.stats.ItemTypeServices;
import com.darkstoryauction.wikiauctions.service.items.base.stats.RarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class ItemServices {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemTypeServices itemTypeServices;

    @Autowired
    private RarityService rarityService;

    //Entity Manager
    @Autowired
    private EntityManager entityManager;

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Transactional
    public String addItem(Item newItem) {
        //check if item type exist.
        newItem.setName(DataNormalizer.upperCaseTitle(newItem.getName()));
        newItem.getType().setName(DataNormalizer.upperCaseTitle(newItem.getType().getName()));
        newItem.getRarity().setName(DataNormalizer.upperCaseTitle(newItem.getRarity().getName()));
        if (!itemTypeServices.findItemType(newItem.getType()) && !rarityService.findRarity(newItem.getRarity())) {
            entityManager.persist(newItem);
            System.out.println(newItem.getId());
            entityManager.close();
            return newItem.getName() + " Item was created.\n" + newItem;
        }
        return newItem.getName() + " Item was not created.";
    }

    public String UpdateItem(Item updatedItem) {
    return "working on it";
    }

    public Item getItemById(Item item) {
        if (findItemById(item))
            return itemRepo.getReferenceById(item.getId());
        else
            return null;
    }

    public boolean findItemById(Item item) {
        return itemRepo.findById(item.getId()).isPresent();
    }

    //Send a full item builder

    /**
     * Made to build up the Item with its attributes like stats, requirements, jobs, etc.
     * @param item
     * @return
     */
    public ItemBuilder newItemBuilder(Item item, Map<Stats, Integer> statsValueMap,
                                   Map<Requirements, Integer> requirementsValueMap,
                                   List<Job> jobList) {
        ItemBuilder getItem = new ItemBuilder();
        getItem.setItemCore(item);
        getItem.setStatsMap(statsValueMap);
        getItem.setRequirementsMap(requirementsValueMap);
        getItem.setJobList(jobList);
        return getItem;
    }


}
