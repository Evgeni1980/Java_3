package Geekbrains.HomeWork;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Написать метод, который меняет два элемента массива местами.

	    Integer[] arr = {2, 8, 24, 11, 9};
        System.out.println("Исходный массив:" + Arrays.toString(arr));
        swapElements(arr, 2, 3);
        System.out.println("Массив после перестановки: " + Arrays.toString(arr));

        //Написать метод, который преобразует массив в ArrayList.

        List<Integer> list = convertToList(arr);
        System.out.println("Задние 2: " + list.getClass() + " : " + list);

        //Задача......

        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        Float orange1Weight = orangeBox1.getWeight();
        Float orange2Weight = orangeBox2.getWeight();
        Float appleWeight = appleBox.getWeight();
        System.out.println("Вес коробки 1 с апельсинами: " + orange1Weight);
        System.out.println("Вес коробки 2 с апельсинами: " + orange2Weight);
        System.out.println("Вес коробки с яблоками: " + appleWeight);

        System.out.println("Сравнить вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Сравнить вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox));

        orangeBox1.moveAt(orangeBox2);


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

    }
        //Метод для перестановки двух элементов массива местами....

    private static <T> void swapElements(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

        //Метод для преобразования массива в ArraysList...

    private static <E> List<E> convertToList(E[] arr){
        return Arrays.asList(arr);
    }
}
