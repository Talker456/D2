package org.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.model.Sample;
import org.example.demo.model.dto.SampleRequestDto;
import org.example.demo.repository.SampleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public String getSample(Long id) {
        Sample sample = sampleRepository.getSampleById(id);
        return sample.getText();
    }

    public Long postSample(SampleRequestDto sampleRequestDto) {
        String text = sampleRequestDto.getText();
        return sampleRepository.save(sampleRepository.save(Sample.toEntity(text))).getId();
    }
}


//@Service
//@RequiredArgsConstructor
//public class HelloService {
//    private final HelloRepository helloRepository;
//
//    public String getHello(Long id) {
//        Hello hello = helloRepository.getHelloById(id);
//        return hello.getText();
//    }
//
//    public Long postHello(HelloRequestDto helloRequestDto) {
//        String text = helloRequestDto.getText();
//        return helloRepository.save(helloRepository.save(Hello.toEntity(text))).getId();
//    }
//}
//
