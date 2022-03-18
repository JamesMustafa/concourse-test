package com.sap.cloud.tenantlifecycle.dzhem.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SmokeController {

    private final SmokeService smokeService;

    public SmokeController(SmokeService smokeService) {
        this.smokeService = smokeService;
    }

    @PostMapping
    public ResponseEntity<Long> activate() {
        Smoke smoke = smokeService.createSmoke();
        return ResponseEntity.status(HttpStatus.CREATED).body(smoke.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smoke> checkResult(@PathVariable("id") String id) {
        return smokeService.getSmoke(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
