package com.darkstoryauction.wikiauctions.controller.items;

import com.darkstoryauction.wikiauctions.entity.items.Bonus;
import com.darkstoryauction.wikiauctions.service.items.BonusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bonus")
public class BonusResource {

    BonusService bonusService;

    @PostMapping("/add")
    public String addBonus(@RequestBody Bonus newBonus) {
        return bonusService.addBonus(newBonus);
    }

    @GetMapping("/get")
    public List<Bonus> getAllBonus(){
       return bonusService.getAllBonus();
    }

    @DeleteMapping("/delete")
    public String deleteBonus(Bonus delBonus){
        return bonusService.delBonus(delBonus);
    }
}
