package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Admin admin = new Admin();

        Scanner scanner = new Scanner(System.in);

        showMenu(scanner, admin);

    }

    private static void showMenu(Scanner scanner, Admin admin) {
        System.out.println("1.Add new car or 2.Show Car list:");
        int i = scanner.nextInt();
        if (i==1){
            NewCar(scanner, admin);
        }
        if(i==2){
            admin.printCarList();
            Sale(scanner, admin);
            admin.printCarList();
        }
        else showMenu(scanner, admin);
    }

    private static void Sale(Scanner scanner, Admin admin) {
        System.out.println("Select any car that you want to buy:");
        int index = scanner.nextInt();

        if (index >= 0 && index < admin.getCars().size()) {
            admin.saleCar(index);
        } else {
            Sale(scanner, admin);
        }
    }

    private static void NewCar(Scanner scanner, Admin admin) {
        Model model = chooseModelMenu(scanner);

        System.out.println("Enter the price:");
        int price = scanner.nextInt();

        System.out.println("Enter the year:");
        int year = scanner.nextInt();

        Car car = new Car(model, year, price);

        admin.addCar(car);
        Admin.sort();
        showMenu(scanner, admin);
    }

    private static Model chooseModelMenu(Scanner scanner) {
        System.out.println("Enter the  model");
        System.out.println("1.BMW 2.MERCEDES 3.KIA 4.VAZ 5.ERAZ");
        int choosenValue = scanner.nextInt();
        Model model = chooseModel(choosenValue);
        while (model == Model.NO_SELECTED) {
            model = chooseModelMenu(scanner);
        }

        return model;
    }

    private static Model chooseModel(int number) {
        switch (number) {
            case 1:
                return Model.BMW;
            case 2:
                return Model.MERCEDES;
            case 3:
                return Model.KIA;
            case 4:
                return Model.VAZ;
            case 5:
                return Model.ERAZ;
            default:
                return Model.NO_SELECTED;
        }


    }
}
