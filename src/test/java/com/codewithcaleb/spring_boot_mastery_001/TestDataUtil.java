package com.codewithcaleb.spring_boot_mastery_001;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;

public final class TestDataUtil {

    //We do not want this class constructed at all
    //This is similar to a no arg constructor
    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorA() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(1L)
                .name("Caleb Mbugua")
                .age(80)
                .build();
        return authorEntity;
    }

    public static AuthorEntity createTestAuthorB() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(2L)
                .name("Mercy Wanjiru")
                .age(44)
                .build();
        return authorEntity;
    }

    public static AuthorEntity createTestAuthorC() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(3L)
                .name("Joseph Atela")
                .age(24)
                .build();
        return authorEntity;
    }

    public static BookEntity createTestBookA(AuthorEntity authorEntity) {
        BookEntity bookEntity = BookEntity.builder()
                .isbn("8486-76-897897-3")
                .title("Caleb Masters Spring")
                .authorEntity(authorEntity)
                .build();
        return bookEntity;
    }

    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        BookEntity bookEntity = BookEntity.builder()
                .isbn("8486-76-897897-2")
                .title("Caleb Masters Spring")
                .authorEntity(authorEntity)
                .build();
        return bookEntity;
    }

    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        BookEntity bookEntity = BookEntity.builder()
                .isbn("8486-76-897897-1")
                .title("Caleb Masters Spring")
                .authorEntity(authorEntity)
                .build();
        return bookEntity;
    }

}
