package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemBuilder;
import com.darkstoryauction.wikiauctions.service.items.ItemBuilderService;
import com.darkstoryauction.wikiauctions.service.items.ItemServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item_builder")
public class ItemBuilderResource {
    ItemBuilderService itemBuilderService;

    @GetMapping("/get")
    public ItemBuilder getItems() {
        return itemBuilderService.GetItems();
    }

    @PostMapping("/add")
    public String createItem(@RequestBody ItemBuilder item) {
        return itemBuilderService.createItem(item);
    }
}
