package com.company.GameStoreProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate, String> {
    SalesTaxRate findByState(String state);
}
