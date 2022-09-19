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

    @PostMapping("/add")
    public String addItem(@RequestBody Item newItem) {
        System.out.println(newItem);
        return itemServices.addItem(newItem);
    }

    @GetMapping("/get")
    public List<Item> getAllItems() {
        return itemServices.getAllItems();
    }
}
