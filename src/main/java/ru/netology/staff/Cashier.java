package ru.netology.staff;

import ru.netology.Products;
import ru.netology.Shopper;
import ru.netology.SummaryDay;
import ru.netology.Task;

import java.util.HashMap;
import java.util.Map;

//Принцип принцип сегрегации интерфейса (был выделен отдельный интерфейс для реализации
// кассира-инкасатора/администратора/управляющего магазином который в конце рабочего дня производит инкасацию)
//Принцип единственной отвественности (1. Кассир является работником 2.работа кассира - это провести товар
// через кассу - взять у покопателя деньги за покупку и внести их в кассу)


public class Cashier extends Employee implements Task, SummaryDay {
    private String name;  //принцип открытости закрытости
    private String surname; //принцип открытости закрытости
    private static double cost = 0; //принцип открытости закрытости
    Map<Integer, Integer> mapBuyChop = new HashMap<>( ); //? Принцип инверсии зависимости


    public Cashier(String name, String surname) {
        super(name, surname);

    }

    @Override
    public Map<Integer, Integer> getMapBuy(Shopper shopper) {
        mapBuyChop.putAll(super.getMapBuy(shopper));
        return mapBuyChop;
    }

    @Override
    public void getRevenueForTheDay() {
        System.out.println( );
        System.out.println("======================================================================================");
        System.out.println("В кассу поступило " + cost);
    }

    @Override
    public void work(Products products) {
        Map<Integer, Products> mapProduct = products.getProductsList( );
        for (Integer mapBuy : mapBuyChop.keySet( )) {
            int tmp = mapBuy;
            for (Map.Entry<Integer, Products> map : mapProduct.entrySet( )) {
                int tmp1 = map.getKey( );
                Products prod = map.getValue( );
                if (tmp == tmp1) {
                    double tmpCost = products.getDoubleRound(mapBuy.intValue( ) * prod.getPrice( ));
                    System.out.println("Вы оплатили товар:\n " + prod.getTitle( ) + " сумма " + tmpCost);
                    cost += tmpCost;
                }

            }
        }

    }


}
