package org.example.demo.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.repository.SampleRepository;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SampleRequestDto {
    private String text;

    @Builder
    private SampleRequestDto(String text) {
        this.text = text;
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