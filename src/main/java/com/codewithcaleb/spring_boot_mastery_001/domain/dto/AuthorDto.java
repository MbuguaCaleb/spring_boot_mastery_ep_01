package com.codewithcaleb.spring_boot_mastery_001.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Jackson will create an empty Object using a No arguments constructor, then use getters and setters
//to put values in the Object
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private Integer age;
}
