package com.codewithcaleb.spring_boot_mastery_001.mappers.impl;

import com.codewithcaleb.spring_boot_mastery_001.domain.dto.BookDto;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;
import com.codewithcaleb.spring_boot_mastery_001.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {
    private ModelMapper modelMapper;

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }

}
