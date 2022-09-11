package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.ItemType;
import com.darkstoryauction.wikiauctions.repository.items.ItemTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServices {
    @Autowired
    private ItemTypeRepo itemTypeRepo;

    /**
     * Gather all itemTypes.
     * @return List<ItemType>
     */
    public List<ItemType> getAllItemTypes() {
        return itemTypeRepo.findAll();
    }

    /**
     * Create new item type - will normalize the data to uppercase the word
     * @param newItemType
     * @return String message
     */
    public String addItemType(ItemType newItemType) {
        newItemType.setName(DataNormalizer.upperCaseWord(newItemType.getName()));
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
