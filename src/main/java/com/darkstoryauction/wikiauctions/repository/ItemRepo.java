package com.darkstoryauction.wikiauctions.repository;

import com.darkstoryauction.wikiauctions.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
