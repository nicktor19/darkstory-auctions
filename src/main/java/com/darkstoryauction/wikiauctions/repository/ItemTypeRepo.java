package com.darkstoryauction.wikiauctions.repository;

import com.darkstoryauction.wikiauctions.entity.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepo extends JpaRepository<ItemType, String> {

}
