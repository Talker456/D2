package org.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.model.dto.SampleRequestDto;
import org.example.demo.service.SampleService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }

    @GetMapping("/sample/{id}")
    public String getSample(@PathVariable("id") Long id) {
        return sampleService.getSample(id);

    }

    @PostMapping("/sample")
    public Long postSample(@RequestBody SampleRequestDto sampleRequestDto) {
        return sampleService.postSample(sampleRequestDto);
    }

    @GetMapping("/sample/test")
    public String sampleTest() {
        return "test";
    }
}
