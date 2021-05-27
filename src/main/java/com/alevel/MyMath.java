package com.alevel;

import java.awt.*;
import java.awt.font.NumericShaper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class MyMath {
    @Pow
    private String string = "hello";

    @Pow
    private Double aDouble = 3.0;

    private Integer integer = 2;

    @Override
    public String toString() {
        return "MyMath{" +
                "string='" + string + '\'' +
                ", aDouble=" + aDouble +
                ", integer=" + integer +
                '}';
    }
}
