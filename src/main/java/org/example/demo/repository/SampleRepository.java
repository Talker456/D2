package org.example.demo.repository;

import org.example.demo.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {
    Sample getSampleById(Long id);

}


