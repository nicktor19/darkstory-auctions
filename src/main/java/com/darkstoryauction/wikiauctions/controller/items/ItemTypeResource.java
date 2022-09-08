package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemType;
import com.darkstoryauction.wikiauctions.service.items.ItemTypeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item_type")
public class ItemTypeResource {

    private ItemTypeServices itemTypeServices;

    @PostMapping("/add")
    public String  addItemType(@RequestBody ItemType newItemType) {
        //uppercase first letter
        newItemType.setName(newItemType.getName().substring(0,1).toUpperCase() + newItemType.getName().substring(1));
        return itemTypeServices.addItemType(newItemType);
    }

    @DeleteMapping("/delete")
    public String deleteItemType(@RequestBody ItemType delItemType) {
        delItemType.setName(delItemType.getName().substring(0,1).toUpperCase() + delItemType.getName().substring(1));
        return itemTypeServices.deleteItemType(delItemType);
    }
}
