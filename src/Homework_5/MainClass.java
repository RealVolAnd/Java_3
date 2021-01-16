package Homework_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final int TUNNEL_WIDTH = (int) CARS_COUNT / 2;
    public static Car[] cars;


    public static void main(String[] args) {
        int champIndex = -1;

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        cars = new Car[CARS_COUNT];
        RaceRules rules = new RaceRules(CARS_COUNT, TUNNEL_WIDTH);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), rules);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        while (true) {
            if (isAllCarsReadyToStart()) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                rules.ready();
                break;
            }
        }

        while (true) {
            // System.out.println("ИЩЕМ ЧЕМПИОНА");
            champIndex = getChampion();

            if (champIndex >= 0) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + cars[champIndex].getName() + " выиграл гонку!!!");
                break;
            }
        }
        System.out.println("==================================================");
        rules.setWaitingForFinish();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("==================================================");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Топ гонки:");
        sortTop();
        for (Car car : cars) {
            System.out.println(car.getName() + " время:" + car.getRaceTime() / 1000f + " сек.");
        }
    }

    private static void sortTop() {
        Arrays.sort(cars, Comparator.comparing(Car::getRaceTime));
    }

    private static boolean isAllCarsReadyToStart() {
        boolean result = false;
        int carCounter = 0;

        for (Car car : cars) {
            carCounter += car.getReadyState();
        }

        if (carCounter == CARS_COUNT) result = true;
        return result;
    }

    private static int getChampion() {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getFinishDone() == 1) {
                return i;
            }
        }
        return -1;
    }

}
