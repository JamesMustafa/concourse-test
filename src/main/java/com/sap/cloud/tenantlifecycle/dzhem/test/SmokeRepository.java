package com.sap.cloud.tenantlifecycle.dzhem.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokeRepository extends JpaRepository<Smoke, Long> {
}
