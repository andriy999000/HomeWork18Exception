package com.company;

public class ArrayExceptionTest {
    public static void printArray(int[] array,int start,int end){
        int i = 0;
        try {

            for (i = start;i >= start && i <= end; i++) {
                int i1 = array[i];



            }
            System.out.println("Операцыя успешно завершена!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка. Попытка обращения к несуществующему индексу: текущий индекс = " + i + "; размер массива = " + array.length + ";");
        }
    }
}
