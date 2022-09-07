package com.darkstoryauction.wikiauctions.service;

import com.darkstoryauction.wikiauctions.entity.Item;
import com.darkstoryauction.wikiauctions.repository.ItemRepo;
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
        System.out.println(newItem);
        //if (itemTypeServices.findItemType(newItem.getType())) {
            itemRepo.save(newItem);
            return newItem.getName() + " Item was created";
        //}
        //return newItem.getName() + " Item was not created";
    }
}
