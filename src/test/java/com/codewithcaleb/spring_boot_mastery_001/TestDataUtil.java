package com.codewithcaleb.spring_boot_mastery_001;

import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;

public final class TestDataUtil {

    //We do not want this class constructed at all
    //This is similar to a no arg constructor
    private TestDataUtil(){
    }

    public static Author createTestAuthor() {
        Author author = Author.builder()
                .id(1L)
                .name("Caleb Mbugua")
                .age(28)
                .build();
        return author;
    }

   public static Book createTestBook() {
        Book book = Book.builder()
                .isbn("8486-76-897897-3")
                .title("Caleb Masters Spring")
                .authorId(1L)
                .build();
        return book;
    }

}
