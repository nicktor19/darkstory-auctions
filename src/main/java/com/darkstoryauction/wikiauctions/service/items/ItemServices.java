package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.Item;
import com.darkstoryauction.wikiauctions.repository.items.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServices {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemTypeServices itemTypeServices;

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public String addItem(Item newItem) {
        //check if item type exist.
        newItem.setName(DataNormalizer.upperCaseWord(newItem.getName()));
        newItem.getType().setName(DataNormalizer.upperCaseWord(newItem.getType().getName()));
        if (!itemTypeServices.findItemType(newItem.getType())) {
            itemRepo.save(newItem);
            return newItem.getName() + " Item was created";
        }
        return newItem.getName() + " Item was not created";
    }
}
