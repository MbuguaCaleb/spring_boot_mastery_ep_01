package com.codewithcaleb.spring_boot_mastery_001.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Classes that do not come from the starter ideally should have some sensible defaults,
//this the need for autoconfiguration
@Configuration
public class MapperConfig {

    //We now have acess to model mapper inside our application context
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
