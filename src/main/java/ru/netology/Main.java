package ru.netology;

import ru.netology.staff.Cashier;
import ru.netology.staff.Employee;
import ru.netology.staff.HallEmployee;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Products products = new Products( );
        Employee hallEmployee = new HallEmployee("Иван", "Петров");
        Employee cashierEmployee = new Cashier("Марья", "Ивановна");
        Cashier adminCashier = new Cashier("Элона", "Эдуардовна");
        hallEmployee.work(products);
        Shopper shopper = new Shopper( );
        shopper.buyProduct(products);
        cashierEmployee.getMapBuy(shopper);
        cashierEmployee.work(products);
        adminCashier.getRevenueForTheDay( );

    }
}
