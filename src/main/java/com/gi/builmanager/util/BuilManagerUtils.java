package com.gi.builmanager.util;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import java.util.List;

public class BuilManagerUtils {


    public static <S,T> List<T> convertList(List<S> list, Class<S> source, Class<T> target, ConversionService conversionService) {

        return (List<T>) conversionService.convert(
                list,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(source)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(target))
        );
    }
}
