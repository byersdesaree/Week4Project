package com.example.Week4Project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository <Console, Integer> {
    List<Console> findByManufacturer(String manufacturer);
}
