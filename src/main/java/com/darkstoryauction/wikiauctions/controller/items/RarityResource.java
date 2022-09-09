package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Rarity;
import com.darkstoryauction.wikiauctions.service.items.RarityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rarity")
public class RarityResource {

    private RarityService rarityService;

    @PostMapping("/add")
    public String addRarity(@RequestBody Rarity rarity) {
        return rarityService.addRarity(rarity);
    }

    @DeleteMapping("/delete")
    public String delRarity(@RequestBody Rarity rarity) {
        return rarityService.delRarity(rarity);
    }
}
