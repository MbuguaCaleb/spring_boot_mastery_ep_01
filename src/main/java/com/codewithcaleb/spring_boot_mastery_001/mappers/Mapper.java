package com.codewithcaleb.spring_boot_mastery_001.mappers;

//can be of any type and therefore it is going to take in generics
public interface Mapper <A,B> {

    B mapTo(A a);

    A mapFrom (B b);
}
