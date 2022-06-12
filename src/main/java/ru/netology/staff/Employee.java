package ru.netology.staff;

import ru.netology.Shopper;
import ru.netology.SummaryDay;
import ru.netology.Task;

import java.util.HashMap;
import java.util.Map;

public abstract class Employee implements Task {
    private String name;
    private String surname;


    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Map<Integer, Integer> getMapBuy(Shopper shopper) {
        Map<Integer, Integer> buyProducts = shopper.getMapBuy( );
        return buyProducts;

    }
}
