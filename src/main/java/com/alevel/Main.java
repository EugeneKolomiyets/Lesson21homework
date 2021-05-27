package com.alevel;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        MyMath m = new MyMath();
        System.out.println(m.toString());
        pow(m);
        System.out.println(m.toString());
    }

    public static boolean setAccess(Field field,MyMath myMath){
        if (!field.canAccess(myMath))
            if (field.trySetAccessible()) {
                field.setAccessible(true);
                return true;
            }
        return false;
    }

    public static void setBack(Field field,boolean needToChangeBack){
        if (needToChangeBack)
            field.setAccessible(false);
    }

    public static void pow(MyMath myMath) throws IllegalAccessException {

        Field[] fields = myMath.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.getAnnotation(Pow.class)!=null){
                //System.out.format("Type: %s%n", field.getType());
                //System.out.format("GenericType: %s%n", field.getGenericType());
                /*System.out.format("getClass: %s%n", field.getClass());
                System.out.format("getClass: %s%n", (field.getGenericType() instanceof Number));*/

                Class<?> type = field.getType();
                if (type.equals(byte.class)) {
                    boolean needToChangeBack = setAccess(field,myMath);
                    byte sum = (byte) field.get(myMath);
                    field.set(myMath,sum*sum);
                    setBack(field,needToChangeBack);

                } else if (type.equals(int.class)) {
                    boolean needToChangeBack = setAccess(field,myMath);
                    int sum = (int) field.get(myMath);
                    field.set(myMath,sum*sum);
                    setBack(field,needToChangeBack);

                } else if (type.equals(long.class)) {
                    boolean needToChangeBack = setAccess(field,myMath);
                    long sum = (long) field.get(myMath);
                    field.set(myMath,sum*sum);
                    setBack(field,needToChangeBack);

                } else if (type.equals(float.class)) {
                    boolean needToChangeBack = setAccess(field,myMath);
                    float sum = (float) field.get(myMath);
                    field.set(myMath,sum*sum);
                    setBack(field,needToChangeBack);

                } else if (type.equals(double.class)) {
                    boolean needToChangeBack = setAccess(field,myMath);
                    double sum = (double) field.get(myMath);
                    field.set(myMath,sum*sum);
                    setBack(field,needToChangeBack);

                } else if (Number.class.isAssignableFrom(type)) {

                    if (type.equals(Byte.class)) {
                        boolean needToChangeBack = setAccess(field,myMath);
                        Byte sum = (Byte) field.get(myMath);
                        field.set(myMath,sum*sum);
                        setBack(field,needToChangeBack);

                    } else if (type.equals(Integer.class)) {
                        boolean needToChangeBack = setAccess(field,myMath);
                        Integer sum = (Integer) field.get(myMath);
                        field.set(myMath,sum*sum);
                        setBack(field,needToChangeBack);

                    } else if (type.equals(Long.class)) {
                        boolean needToChangeBack = setAccess(field,myMath);
                        Long sum = (Long) field.get(myMath);
                        field.set(myMath,sum*sum);
                        setBack(field,needToChangeBack);

                    } else if (type.equals(Float.class)) {
                        boolean needToChangeBack = setAccess(field,myMath);
                        Float sum = (Float) field.get(myMath);
                        field.set(myMath,sum*sum);
                        setBack(field,needToChangeBack);

                    } else if (type.equals(Double.class)) {
                        boolean needToChangeBack = setAccess(field,myMath);
                        Double sum = (Double) field.get(myMath);
                        field.set(myMath,sum*sum);
                        setBack(field,needToChangeBack);
                    }
                }
            }
        }
    }

}
