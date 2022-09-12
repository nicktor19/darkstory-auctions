package com.darkstoryauction.wikiauctions.entity.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemStats {
    @Id
    @SequenceGenerator(
            name = "itemStat_sequence",
            sequenceName = "itemStat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "itemStat_sequence"
    )
    private int Id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "item_stats_id")
    private ItemStats itemStats;
    private int value;
}
