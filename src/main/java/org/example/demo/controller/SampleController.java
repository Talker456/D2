package org.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.model.dto.SampleListViewResponse;
import org.example.demo.model.dto.SampleRequestDto;
import org.example.demo.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SampleController {
    private final SampleService sampleService;
    private final Logger log = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample/{id}")
    public String getSample(@PathVariable("id") Long id) {
        return sampleService.getSample(id);
    }

    @GetMapping("/samples")
    public String getSamples(Model model) {
        List<SampleListViewResponse> samples = sampleService.findAll()
                .stream()
                .map(SampleListViewResponse::new)
                .toList();
        model.addAttribute("samples", samples);
        return "samples";
    }

    @GetMapping("/index")
    public String index() {
        return "plans";
    }
}
