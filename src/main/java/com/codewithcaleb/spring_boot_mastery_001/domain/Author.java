package com.codewithcaleb.spring_boot_mastery_001.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id //-->denotes a primary Key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq") // instead of me having to add an ID and put in values when instantiating an Object, Spring will handle this on my behalf
    private Long id;
    private String name;
    private Integer age;
}
