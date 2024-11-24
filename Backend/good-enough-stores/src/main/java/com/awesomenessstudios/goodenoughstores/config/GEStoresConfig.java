package com.awesomenessstudios.goodenoughstores.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GEStoresConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
