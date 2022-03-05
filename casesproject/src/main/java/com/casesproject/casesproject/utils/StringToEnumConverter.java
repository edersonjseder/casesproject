package com.casesproject.casesproject.utils;

import org.springframework.core.convert.converter.Converter;

import com.casesproject.casesproject.enums.Status;

@RequestParameterConverter
public class StringToEnumConverter implements Converter<String, Status> {
    @Override
    public Status convert(String source) {
        return Status.decode(source.toUpperCase());
    }
}
