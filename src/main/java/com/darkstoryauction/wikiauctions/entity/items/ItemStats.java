package com.darkstoryauction.wikiauctions.entity.items;

import com.darkstoryauction.wikiauctions.entity.items.base.stats.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @ManyToOne(cascade = {CascadeType.ALL})
    private Item itemId;
    @ManyToOne
    @JoinColumn(name = "stats_id_name")
    private Stats stats_id;
    private int value;
}
