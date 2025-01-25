package org.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.model.Sample;
import org.example.demo.model.dto.SampleRequestDto;
import org.example.demo.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public String getSample(Long id) {
        Sample sample = sampleRepository.getSampleById(id);
        return sample.getText();
    }

//    public Long postSample(SampleRequestDto sampleRequestDto) {
//        String text = sampleRequestDto.getText();
//        return sampleRepository.save(sampleRepository.save(Sample.toEntity(text))).getId();
//    }

    public List<Sample> findAll() {
        return sampleRepository.findAll();
    }

    public Sample save(SampleRequestDto sample) {
        return sampleRepository.save(sample.toEntity());
    }
}

