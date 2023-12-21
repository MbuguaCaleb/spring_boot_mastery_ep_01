package com.codewithcaleb.spring_boot_mastery_001.mappers.impl;

import com.codewithcaleb.spring_boot_mastery_001.domain.dto.AuthorDto;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import com.codewithcaleb.spring_boot_mastery_001.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity,AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
