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

    @PostMapping
    public ResponseEntity<Integer> activate() {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(69);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> checkResult(@PathVariable("id") Integer id) {
        if (id != 69) {
            return ResponseEntity.notFound()
                                 .build();
        }
        return ResponseEntity.ok("Success");
    }
}
