package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Rarity;
import com.darkstoryauction.wikiauctions.service.items.base.stats.RarityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rarity")
public class RarityResource {

    private RarityService rarityService;

    @GetMapping("/get")
    public List<Rarity> getAllRarities() {
        return rarityService.getAllRarities();
    }

    @PostMapping("/add")
    public String addRarity(@RequestBody Rarity rarity) {
        return rarityService.addRarity(rarity);
    }

    @DeleteMapping("/delete")
    public String delRarity(@RequestBody Rarity rarity) {
        return rarityService.delRarity(rarity);
    }
}
