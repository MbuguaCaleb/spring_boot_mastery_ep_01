package com.codewithcaleb.spring_boot_mastery_001;

import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;

public final class TestDataUtil {

    //We do not want this class constructed at all
    //This is similar to a no arg constructor
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        Author author = Author.builder()
                .id(1L)
                .name("Caleb Mbugua")
                .age(28)
                .build();
        return author;
    }

    public static Author createTestAuthorB() {
        Author author = Author.builder()
                .id(2L)
                .name("Mercy Wanjiru")
                .age(28)
                .build();
        return author;
    }

    public static Author createTestAuthorC() {
        Author author = Author.builder()
                .id(3L)
                .name("Joseph Atela")
                .age(28)
                .build();
        return author;
    }

    public static Book createTestBookA() {
        Book book = Book.builder()
                .isbn("8486-76-897897-3")
                .title("Caleb Masters Spring")
                .authorId(1L)
                .build();
        return book;
    }

    public static Book createTestBookB() {
        Book book = Book.builder()
                .isbn("8486-76-897897-2")
                .title("Caleb Masters Spring")
                .authorId(1L)
                .build();
        return book;
    }

    public static Book createTestBookC() {
        Book book = Book.builder()
                .isbn("8486-76-897897-1")
                .title("Caleb Masters Spring")
                .authorId(1L)
                .build();
        return book;
    }

}
