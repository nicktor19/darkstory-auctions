package com.darkstoryauction.wikiauctions.entity.items;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.ItemType;
import com.darkstoryauction.wikiauctions.entity.items.base.stats.Rarity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_name")
    private ItemType type;
    @ManyToOne
    @JoinColumn(name = "rarity_name")
    private Rarity rarity;
    private String pictureUrl;
}
