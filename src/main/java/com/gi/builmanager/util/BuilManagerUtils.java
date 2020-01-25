package com.gi.builmanager.util;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BuilManagerUtils {


    public static <S,T> List<T> convertList(List<S> list, Class<S> source, Class<T> target, ConversionService conversionService) {

        return (List<T>) conversionService.convert(
                list,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(source)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(target))
        );
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
