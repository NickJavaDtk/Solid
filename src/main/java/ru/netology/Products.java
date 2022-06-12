package ru.netology;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Products implements Iterable<Integer> {
    //Принцип замены Барбары Лисков
    private String title; //принцип открытости закрытости
    private Double price; //принцип открытости закрытости
    private Map<Integer, Products> productsList;
    private Random rand = new Random( );
    String[] productsTitle = {"Хлеб", "Картофель", "Морковь", "Лук", "Гречка", "Перловка",
            "Рис", "Сгущенка", "Мед", "Куриное филе", "Свинина", "Сало", "Стручковая фасоль",
            "Маргарин", "Сыр", "Масло сливочное", "Кефир", "Молоко", "Сметана",
            "Творог", "Мешки для мусора", "Наполнитель для кошачьего туалета", "Пакеты пищевые"};

    public Products(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Products() {
        productsList = new HashMap<>( );
        for (int i = 0; i < productsTitle.length; i++) {
            price = rand.nextDouble( ) + rand.nextInt(5);
            price = getDoubleRound(price);
            productsList.put(i + 1, new Products(productsTitle[i], price));
        }
    }

    public Map<Integer, Products> getProductsList() {
        return productsList;
    }

    @Override
    public Iterator<Integer> iterator() {
        return productsList.keySet( ).iterator( );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDoubleRound(double d) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue( );
    }
}
