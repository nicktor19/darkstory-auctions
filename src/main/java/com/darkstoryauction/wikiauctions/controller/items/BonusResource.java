package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Bonus;
import com.darkstoryauction.wikiauctions.service.items.BonusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bonus")
public class BonusResource {

    BonusService bonusService;

    @PostMapping("/add")
    public String addBonus(@RequestBody Bonus newBonus) {
        return bonusService.addBonus(newBonus);
    }
}
