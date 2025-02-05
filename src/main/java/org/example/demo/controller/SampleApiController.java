package org.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.model.Sample;
import org.example.demo.model.dto.SampleRequestDto;
import org.example.demo.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SampleApiController {
    private final SampleService sampleService;
    private final Logger logger = LoggerFactory.getLogger(SampleApiController.class);

    @PostMapping("/api/sample")
    public ResponseEntity<Sample> addSample(@RequestBody SampleRequestDto request) {
        logger.info("POST /api/sample");
        Sample savedEntity = sampleService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedEntity);
    }
}
