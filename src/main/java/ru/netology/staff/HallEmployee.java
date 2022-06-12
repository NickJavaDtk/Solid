package ru.netology.staff;

import ru.netology.Products;
import ru.netology.Task;

import java.util.ArrayList;
import java.util.List;


//принцип единственной отвественности (1. Работник зала является работником 2. Работник зала выполняет свою работу
// - раскладывает по полкам продукты)

public class HallEmployee extends Employee implements Task {
    private String name; //принцип открытости закрытости
    private String surname; //принцип открытости закрытости


    public HallEmployee(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void work(Products products) {
        System.out.println("До открытия магазина работник зала выставил на полки следующие товары");
        for (Products map : products.getProductsList( ).values( )) {
            getSection(map.getTitle( ));

        }

    }

    public void getSection(String title) {
        List<String[]> listSection = new ArrayList<>( );

        String[] grain = {"Гречка", "Перловка", "Рис", "Стручковая фасоль"};
        listSection.add(grain);
        String[] milk = {"Сгущенка", "Маргарин", "Сыр", "Масло сливочное", "Кефир", "Молоко", "Сметана",
                "Творог"};
        listSection.add(milk);
        String[] bakery = {"Хлеб", "Мед"};
        listSection.add(bakery);
        String[] meet = {"Куриное филе", "Свинина", "Сало"};
        listSection.add(meet);
        String[] veggi = {"Картофель", "Морковь", "Лук"};
        listSection.add(veggi);
        String[] different = {"Мешки для мусора", "Наполнитель для кошачьего туалета", "Пакеты пищевые"};
        listSection.add(different);
        for (String[] section : listSection) {
            for (String product : section) {
                if (product.equals(title) && section == grain) {
                    System.out.println("В отдел \"Крупы\" выставлена крупа " + product);
                } else if (product.equals(title) && section == milk) {
                    System.out.println("В отдел \"Молочная продукция\" были выставлены продукты " + product);
                } else if (product.equals(title) && section == bakery) {
                    System.out.println("В отдел \"Выпечка\" были выставлены продукты " + product);
                } else if (product.equals(title) && section == meet) {
                    System.out.println("В отдел \"Мясо\" следующие продукты " + product);
                } else if (product.equals(title) && section == veggi) {
                    System.out.println("В отдел \"Овощи\" были выставлены продукты " + product);
                } else if (product.equals(title) && section == different) {
                    System.out.println("В отдел \"Разное\" были выставлены продукты " + product);
                }

            }
        }
    }
}
