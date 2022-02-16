package com.sap.cloud.tenantlifecycle.dzhem.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SmokeService {

    private final SmokeRepository smokeRepository;

    public SmokeService(SmokeRepository smokeRepository) {
        this.smokeRepository = smokeRepository;
    }

    @Transactional
    public Smoke createSmoke() {
        Smoke smoke = new Smoke();
        smoke.setTitle("Smoke test");
        return smokeRepository.save(smoke);
    }

    @Transactional
    public Optional<Smoke> getSmoke(Long id) {
        return smokeRepository.findById(id);
    }
}
