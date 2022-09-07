package com.darkstoryauction.wikiauctions.service;

import com.darkstoryauction.wikiauctions.entity.ItemType;
import com.darkstoryauction.wikiauctions.repository.ItemTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServices {
    @Autowired
    private ItemTypeRepo itemTypeRepo;

    /**
     * Create new item type
     * @param newItemType
     * @return String message
     */
    public String addItemType(ItemType newItemType) {
        if (findItemType(newItemType)) {
            itemTypeRepo.save(newItemType);
            return newItemType.getName() + " was added to Item Types.";
        }
        return newItemType.getName() + " already exist";
    }

    /**
     * Checks if Item Type already exist.
     * @param itemType
     * @return boolean, if empty return true to allow access to next step.
     */
    public boolean findItemType(ItemType itemType) {
        return itemTypeRepo.findById(itemType.getName()).isEmpty();
    }

    public String deleteItemType(ItemType itemType) {
        if (!findItemType(itemType)) {
            itemTypeRepo.delete(itemType);
            return itemType.getName() + " was deleted.";
        }
        return itemType.getName() + " doesn't exist to delete.";
    }


}