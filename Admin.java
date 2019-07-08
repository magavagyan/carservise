package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Admin {
    private int profit;
    private static List<Car> cars = new ArrayList<>();

    public static void sort() {
        Comparator<Car> qCar = new SortByModel().thenComparing(new SortByYear().thenComparing(new SortByPrice()));
        Collections.sort(cars, qCar);
    }

    public int getProfit() {
        return profit;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    private void incrementProfit(int carPrice) {
        profit += carPrice;
    }

    public void printCarList() {
        int index = 0;
        for (Car car : cars) {
            System.out.println(index + " " + car.toString());
            index++;
        }
        System.out.println("Profit = " + profit);
    }

    public void saleCar(int index) {
        Car car = cars.get(index);
        incrementProfit(car.getPrice());
        cars.remove(car);
        System.out.println(" You buy " + car.getModel().getName());
    }
}
