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
    protected int id;
    @Column(nullable = false)
    protected String name;
    @ManyToOne
    @JoinColumn(name = "type_name")
    protected ItemType type;
    @ManyToOne
    @JoinColumn(name = "rarity_name")
    protected Rarity rarity;
    protected String pictureUrl;
    protected int slots;
}
