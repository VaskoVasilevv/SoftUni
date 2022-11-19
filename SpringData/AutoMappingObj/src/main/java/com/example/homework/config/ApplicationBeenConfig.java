package com.example.homework.config;

import com.example.homework.model.dto.AddGameDto;
import com.example.homework.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeenConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(AddGameDto.class, Game.class)
                .addMappings(mapper -> mapper
                        .map(AddGameDto::getThumbnailURL, Game::setImageThumbnail))
        .addMappings(mapper -> mapper
                .map(AddGameDto::getReleaseDate,Game::setReleaseDate));



        Converter<String, LocalDate> localDateConverter =
                new Converter<String, LocalDate>() {
                    @Override
                    public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                        return LocalDate.parse(mappingContext.getSource()
                                , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    }
                };
        modelMapper.addConverter(localDateConverter);



        return modelMapper;
    }
}


