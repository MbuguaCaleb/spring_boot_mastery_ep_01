package com.codewithcaleb.spring_boot_mastery_001.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String isbn;
    private String title;

    //reperesents the foregin key constraint
    private Long authorId;
}
