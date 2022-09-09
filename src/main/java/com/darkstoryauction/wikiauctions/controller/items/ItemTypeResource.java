package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
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
        newItemType.setName(DataNormalizer.upperCaseWord(newItemType.getName()));
        return itemTypeServices.addItemType(newItemType);
    }

    @DeleteMapping("/delete")
    public String deleteItemType(@RequestBody ItemType delItemType) {
        delItemType.setName(DataNormalizer.upperCaseWord(delItemType.getName()));
        return itemTypeServices.deleteItemType(delItemType);
    }
}
