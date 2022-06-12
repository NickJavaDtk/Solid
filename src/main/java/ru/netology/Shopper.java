package ru.netology;

import ru.netology.staff.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shopper {
    //Принцип замены Барбары Лисков (Покупатель не является никаким работником (т. е. он где-то работает),
    // (но в текущий момент он является покупателем и работником магазина не является) - наследоваться
    // от класса работника нельзя
    private int i = 1;
    Map<Integer, Integer> buyProduct = new HashMap<>( );
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void buyProduct(Products products) throws IOException {
        System.out.println("==================================================================");
        System.out.println("Добрый день\nСегодня в нашем магазине доступны следующие товары ");
        Map<Integer, Products> mapProduct = products.getProductsList( );
        for (Products map : mapProduct.values( )) {
            System.out.println(i + "." + " " + map.getTitle( ) + " " + map.getPrice( ));
            i++;
        }
        while (true) {
            try {
                System.out.println("Для того чтобы положить товар в корзину введите номер товар и количество" +
                        " Пример \"5 \"2 или введите \"end\" для окончания покупки");

                String input = br.readLine( );
                if (input.equals("end")) {
                    break;
                }
                String[] s = input.split(" ");
                int first = Integer.parseInt(s[0]);
                int last = Integer.parseInt(s[1]);
                if (first <= 0 || first > mapProduct.size( )) {
                    System.out.println("Такого товара в списке нет");
                    continue;

                } else if (last <= 0) {
                    System.out.println("Количество товара должно быть больше нуля");
                    continue;

                } else {
                    buyProduct.put(first, last);
                }

            } catch (Exception e) {
                e.printStackTrace( );
            }

        }
        br.close( );
    }

    public Map<Integer, Integer> getMapBuy() {
        return buyProduct;

    }
}
