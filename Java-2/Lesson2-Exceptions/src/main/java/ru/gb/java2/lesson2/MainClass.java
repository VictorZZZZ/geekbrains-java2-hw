package ru.gb.java2.lesson2;

import ru.gb.java2.lesson2.exceptions.WrongArraySizeException;

public class MainClass {
    public static void main(String[] args) {
        String str = "4 5 3 2\n2 8 3 2\n5 6 7 1\n300 3 1 0";
        String[][] strArray = new String[0][];
        try {
            strArray = convertStringToArray(str);
            int[][] intArray = convertToInt(strArray);
            float result = processArray(intArray);
            System.out.println(result);
        } catch (WrongArraySizeException e) {
            System.out.printf("Ошибка размерности массива:\n %s",e.getMessage());
        } catch (NumberFormatException e){
            System.out.printf("Ошибка преобразования массива String в Integer:\n %s",e.getMessage());
        }

    }

    private static String[][] convertStringToArray(String str) throws WrongArraySizeException {
        String[] strRow = str.split("\n");
        if(strRow.length!=4) throw new WrongArraySizeException("Array Size should be 4x4");
        String[][] result = new String[strRow.length][];
        for(int i=0;i<strRow.length;i++) {
            if(strRow[i].split(" ").length!=4) throw new WrongArraySizeException("Array Size is not 4x4");
            result[i] = strRow[i].split(" ");
        }
        return result;
    }

    private static int[][] convertToInt(String[][] strArray) throws NumberFormatException{
        int[][] result = new int[strArray.length][];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = new int[strArray[i].length];
            for (int j = 0; j < strArray[i].length ; j++) {
                result[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }
        return result;
    }

    private static float processArray(int[][] matrix){
        int sum=0;
        for (int i = 0; i < matrix.length ; i++)
            for (int j = 0; j < matrix[i].length; j++)
                sum+=matrix[i][j];
        return sum/2f;
    }
}
