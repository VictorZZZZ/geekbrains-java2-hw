package ru.gb.GenArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class GenArrays {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("Array Before the changing elements \n"+arrayList);
        ArrayList<Integer> newArrayList = changeElements(arrayList,2,4);
        System.out.println("Array After the changing elements \n"+newArrayList);

        System.out.println("\n\n");

        String[] arrayToConvert = new String[]{"S1", "S2", "S3"};
        System.out.println("Array to convert array to ArrayList:"+ Arrays.toString(arrayToConvert));
        ArrayList<String> convertedArray = convertArrayToArrayList(arrayToConvert);
        System.out.println("Converted array:"+ convertedArray);
     }

    public static <T> ArrayList<T> convertArrayToArrayList(T... array){
        ArrayList<T> result = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public static <T> ArrayList<T> changeElements(ArrayList<T> arrayList,int i1,int i2){
        ArrayList<T> result = new ArrayList<T>();
        if(i1>arrayList.size() || i2>arrayList.size()){
            throw new RuntimeException("index out of bound");
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(i==i1) {
                result.add(arrayList.get(i2));
            } else if(i==i2){
                result.add(arrayList.get(i1));
            } else{
                result.add(arrayList.get(i));
            }

        }
        return result;
    }


}
