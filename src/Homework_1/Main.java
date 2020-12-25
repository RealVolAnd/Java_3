package Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        /*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:

a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.

         */

//Задание 1
        Integer array1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String array2[] = {"A", "B", "C", "D"};
        Orange array3[] = {new Orange(), new Orange(), new Orange()};
        swap(array1, 0, 1);
        swap(array2, 0, 1);
        swap(array3, 0, 1);

//Задание 2.
        String[] array = {"A", "B", "C", "D"};
        asList(array);

//Задание 3.
        System.out.println("\n------------- Задание 3 --------------");

        //Создаем коробки
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Orange> orangeBox = new FruitBox<>();

        //Наполняем коробки фруктами
        addFruitsInBox(appleBox, 10, Apple.class);
        addFruitsInBox(orangeBox, 20, Orange.class);

        //Количество фруктов в коробках
        System.out.println("Количество яблок в коробке:" + appleBox.getCount());
        System.out.println("Количество апельсинов в коробке:" + orangeBox.getCount());

        //Вес фруктов по коробкам
        System.out.println("\nВес яблок:" + appleBox.getWeight());
        System.out.println("Вес апельсинов:" + orangeBox.getWeight()+"\n");

        //Сравнение веса коробок
        if(appleBox.compare(orangeBox)){
            System.out.println("Коробки равны по весу\n");
        } else {
            System.out.println("Вес у коробок разный\n");
        }

        //Пересыпаем яблоки
        FruitBox<Apple> appleBox1 = new FruitBox<>();
        addFruitsInBox(appleBox1, 30, Apple.class);
        FruitBox<Apple> appleBox2 = new FruitBox<>();
        addFruitsInBox(appleBox2, 20, Apple.class);

        System.out.println("Количество яблок в коробке №1:" + appleBox1.getCount());
        System.out.println("Количество яблок в коробке №2:" + appleBox2.getCount());
        System.out.println("\nПересыпаем яблоки из коробки №1 в коробку №2\n");
        appleBox1.turnTo(appleBox2);
        System.out.println("Количество яблок в коробке №1:" + appleBox1.getCount());
        System.out.println("Количество яблок в коробке №2:" + appleBox2.getCount());

    }

    public static <T extends Fruits> void addFruitsInBox(FruitBox<T> box, int count, Class<T> clas) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < count; i++) {
            box.add(clas.newInstance());
        }
    }


    public static <T> void swap(T[] array, int a1, int a2) {
        System.out.println("\nЗадание 1");
        System.out.println("Исходный массив: " + Arrays.toString(array));
        T tmp = array[a1];
        array[a1] = array[a2];
        array[a2] = tmp;
        System.out.println("Результат: " + Arrays.toString(array));
    }

    public static <T> void asList(T[] array) {
        System.out.println("\nЗадание 2 \nИсходный массив: " + array.getClass().getName() + ":" + Arrays.toString(array));
        ArrayList<T> result = new ArrayList<>(Arrays.asList(array));
        System.out.println("Результат: " + result.getClass().getName() + ":" + result);
    }
}
