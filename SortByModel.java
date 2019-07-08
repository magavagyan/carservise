package com.company;

import java.util.Comparator;

public class SortByModel implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().getName().compareTo(o2.getModel().getName());
    }

}
