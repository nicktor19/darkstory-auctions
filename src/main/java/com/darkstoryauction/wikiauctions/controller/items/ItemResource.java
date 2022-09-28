package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Item;
import com.darkstoryauction.wikiauctions.service.items.ItemServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item")
public class ItemResource {

    public ItemServices itemServices;

//    /**
//     * Will return the items ID to make the rest of the items stats.
//     * @param newItem
//     * @return int (the items ID)
//     */
//    @PostMapping("/add")
//    public int addItem(@RequestBody Item newItem) {
//        //System.out.println(newItem);
//        newItem.setName(newItem.getName());
//        itemServices.addItem(newItem);
//        return newItem.getId();
//    }

    @GetMapping("/get")
    public List<Item> getAllItems() {
        return itemServices.getAllItems();
    }
}
