package com.company.GameStoreProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt,Integer> {

    List<TShirt> findTShirtByColor(String color);
    List<TShirt> findTShirtBySize(String size);
}
