package com.darkstoryauction.wikiauctions.controller;

import com.darkstoryauction.wikiauctions.entity.Item;
import com.darkstoryauction.wikiauctions.service.ItemServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/item")
public class ItemResource {

    public ItemServices itemServices;

    @PostMapping("/add")
    public String addItem(@RequestBody Item newItem) {
        return itemServices.addItem(newItem);
    }
}
