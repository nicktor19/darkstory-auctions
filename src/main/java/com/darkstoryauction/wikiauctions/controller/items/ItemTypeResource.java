package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.datanormalizer.DataNormalizer;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.ItemType;
import com.darkstoryauction.wikiauctions.service.items.base.stats.ItemTypeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item_type")
public class ItemTypeResource {
    private ItemTypeServices itemTypeServices;

    @GetMapping("/get")
    public List<ItemType> getAllItemTypes() {
        return itemTypeServices.getAllItemTypes();
    }

    @PostMapping("/add")
    public String  addItemType(@RequestBody ItemType newItemType) {
        //uppercase first letter
        newItemType.setName(DataNormalizer.upperCaseTitle(newItemType.getName()));
        return itemTypeServices.addItemType(newItemType);
    }

    @DeleteMapping("/delete")
    public String deleteItemType(@RequestBody ItemType delItemType) {
        delItemType.setName(DataNormalizer.upperCaseTitle(delItemType.getName()));
        return itemTypeServices.deleteItemType(delItemType);
    }
}
