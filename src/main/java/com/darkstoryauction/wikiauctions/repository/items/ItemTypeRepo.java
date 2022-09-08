package com.darkstoryauction.wikiauctions.repository.items;

import com.darkstoryauction.wikiauctions.entity.items.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepo extends JpaRepository<ItemType, String> {

}
