package com.darkstoryauction.wikiauctions.service.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBuilderService {

    @Autowired
    ItemServices itemServices;

    @Autowired
    ItemStatsServices itemStatsServices;

    //get
    public ItemBuilder GetItems() {
        //get item using item numbers
        ItemBuilder test = new ItemBuilder();
        return test.testJSON();
    }
    //create
    public String createItem(ItemBuilder item) {
        if (item!=null){
            if (item.getItemCore() == null || item.getItemCore().getName().trim().isEmpty())
                return "Could not create this item: \n" + item.getItemCore().getName();
            // error checking
            // ensure all stats are right
            if(!itemStatsServices.statExist(item.getStatsMap())) {
                return "Could not create because the item has an unknown stat.";
            }
            //create item and get the id when created.
            int itemID = itemServices.addItem(item.getItemCore());
            if (itemID > 0){
                itemStatsServices.addItemStats(item.getItemCore(), item.getStatsMap());
            }

            return "Created item: \n" + item.getItemCore().getName();
        } else {
            return "Could not create this item: \n" + item.getItemCore().getName();
        }
    }
    //update

    //delete
}
