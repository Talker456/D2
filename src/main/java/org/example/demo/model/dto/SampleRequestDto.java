package org.example.demo.model.dto;

import lombok.*;
import org.example.demo.model.Sample;
import org.example.demo.repository.SampleRepository;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequestDto {
    private String text;

    public Sample toEntity() {
        return Sample.builder()
                .text(text)
                .build();
    }
}



//@Getter
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class HelloRequestDto {
//    private String text;
//
//    @Builder
//    private HelloRequestDto(String text) {
//        this.text = text;
//    }
//}
//