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
@Table(name = "books")
public class Book {

    @Id //i i annotate any other column ,it will automatically be the primaryKey
    private String isbn;

    private String title;

    //foreign key authorId in JPA Context
    //An author can have many books, a book can have only one author (Many to One Relationship)
    //CascadeType.ALL -->Means that if i fetch an author, i also fetch the books
    //When i save the book i also save the author ID as long as it is passed
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

}
