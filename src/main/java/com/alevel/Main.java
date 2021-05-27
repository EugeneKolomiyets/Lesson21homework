package com.alevel;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        MyMath m = new MyMath();
        System.out.println(m.toString());
        Pow(m);
        System.out.println(m.toString());
    }

    public static void Pow(MyMath myMath) throws IllegalAccessException {

        Field[] fields = myMath.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.getAnnotation(Pow.class)!=null){
                //System.out.format("Type: %s%n", field.getType());
                //System.out.format("GenericType: %s%n", field.getGenericType());
                /*System.out.format("getClass: %s%n", field.getClass());
                System.out.format("getClass: %s%n", (field.getGenericType() instanceof Number));*/

                Class<?> type = field.getType();
                if (type.equals(byte.class)) {
                    field.setAccessible(true);
                    byte sum = (byte) field.get(myMath);
                    field.set(myMath,sum*sum);
                    field.setAccessible(false);

                } else if (type.equals(int.class)) {
                    field.setAccessible(true);
                    int sum = (int) field.get(myMath);
                    field.set(myMath,sum*sum);
                    field.setAccessible(false);

                } else if (type.equals(long.class)) {
                    field.setAccessible(true);
                    long sum = (long) field.get(myMath);
                    field.set(myMath,sum*sum);
                    field.setAccessible(false);

                } else if (type.equals(float.class)) {
                    field.setAccessible(true);
                    float sum = (float) field.get(myMath);
                    field.set(myMath,sum*sum);
                    field.setAccessible(false);

                } else if (type.equals(double.class)) {
                    field.setAccessible(true);
                    double sum = (double) field.get(myMath);
                    field.set(myMath,sum*sum);
                    field.setAccessible(false);

                } else if (Number.class.isAssignableFrom(type)) {

                    if (type.equals(Byte.class)) {
                        field.setAccessible(true);
                        Byte sum = (Byte) field.get(myMath);
                        field.set(myMath,sum*sum);
                        field.setAccessible(false);

                    } else if (type.equals(Integer.class)) {
                        field.setAccessible(true);
                        Integer sum = (Integer) field.get(myMath);
                        field.set(myMath,sum*sum);
                        field.setAccessible(false);

                    } else if (type.equals(Long.class)) {
                        field.setAccessible(true);
                        Long sum = (Long) field.get(myMath);
                        field.set(myMath,sum*sum);
                        field.setAccessible(false);

                    } else if (type.equals(Float.class)) {
                        field.setAccessible(true);
                        Float sum = (Float) field.get(myMath);
                        field.set(myMath,sum*sum);
                        field.setAccessible(false);

                    } else if (type.equals(Double.class)) {
                        field.setAccessible(true);
                        Double sum = (Double) field.get(myMath);
                        field.set(myMath,sum*sum);
                        field.setAccessible(false);
                    }
                }
            }
        }
    }

}
