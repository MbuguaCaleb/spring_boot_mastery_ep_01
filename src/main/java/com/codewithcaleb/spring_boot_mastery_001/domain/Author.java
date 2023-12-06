package com.codewithcaleb.spring_boot_mastery_001.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Remeber this which reprsents the entities should not be injected into the context
//We should just have the appropriate getters and setters
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private Long id;
    private String name;
    private Integer age;
}
