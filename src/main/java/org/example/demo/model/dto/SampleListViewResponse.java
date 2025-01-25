package org.example.demo.model.dto;


import lombok.Getter;
import org.example.demo.model.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Getter
public class SampleListViewResponse {
    private final Logger logger = LoggerFactory.getLogger(SampleListViewResponse.class);


    private final Long id;
    private final String text;
    private final LocalDateTime createdAt;

    public SampleListViewResponse(Sample sample) {
        this.id = sample.getId();
        this.text = sample.getText();
        this.createdAt = sample.getCreatedAt();

        logger.info("SampleListViewResponse created for sample with id: {}", id);
    }
}
