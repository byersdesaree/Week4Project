package com.company.GameStoreProject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface processingFeeRepository extends JpaRepository<processingFee, String> {
    processingFee findByProductType(String productType);
}
