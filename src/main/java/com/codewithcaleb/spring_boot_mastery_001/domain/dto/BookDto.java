package com.codewithcaleb.spring_boot_mastery_001.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String isbn;

    private String title;

    //foreign key relationship now is the author DTO
    private AuthorDto author;
}
