package com.aruizmontana.application;

import com.aruizmontana.data.datasource.remote.PairRemoteDataSourceImpl;
import com.aruizmontana.data.repository.IPairRepository;
import com.aruizmontana.data.repository.PairRepositoryImpl;
import com.aruizmontana.domain.model.PairModel;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppMain {

    private IPairRepository repository;
    private Scanner scanner;

    public AppMain() {
        scanner = new Scanner(System.in);
        repository = new PairRepositoryImpl(new PairRemoteDataSourceImpl());
    }

    public void exchange() {
        boolean flag = true;
        do {
            var result = getMainMenu();
            String base = "", target = "";
            switch (result) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    break;
                case 2:
                    target = "USD";
                    base = "ARS";
                    break;
                case 3:
                    base = "USD";
                    target = "BRL";
                    break;
                case 4:
                    target = "USD";
                    base = "BRL";
                    break;
                case 5:
                    base = "USD";
                    target = "COP";
                    break;
                case 6:
                    target = "USD";
                    base = "COP";
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    target = "";
                    base = "";
                    break;
            }

            if(!target.isEmpty() && !base.isEmpty()) {
                System.out.println(convertPairModel(repository.pair(base,target,getAmountMenu())));
            } else if(!flag) {
                break;
            } else {
                System.out.println("Elija una opcion valida\n");
            }
            onKeyEvent();
            System.out.print("\033[H\033[2J\n\n\n\n");
            System.out.flush();
        } while (true);

    }

    private int getMainMenu() {
        String menu = "MENU\n" +
                "1. Dólar estadounidense => Peso Argentino\n" +
                "2. Peso Argetino => Dólar estadounidense\n" +
                "3. Dólar estadounidense =>  Real brasileño\n" +
                "4. Real brasileño => Dólar estadounidense\n" +
                "5. Dólar estadounidense => Peso Colombiano\n" +
                "6. Peso Colombiano => Dólar estadounidense\n" +
                "7. Salir\n" +
                "Elija una opcion valida\n" +
                "**************************";

        System.out.println(menu);
        var result = scanner.nextLine();
        return tryParseInt(result);
    }

    private double getAmountMenu() {
        System.out.println("Ingrese el monto a convertir. ep(15.5)");
        var result = scanner.nextLine();
        return tryParseDouble(result.replace(',', '.'));

    }

    private void onKeyEvent() {
        System.out.println("Presione la telca Enter para continuar.....");
        scanner.nextLine();
    }

    private double tryParseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private int tryParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String convertPairModel(PairModel pair) {
        return "Total: " +
                priceWithoutDecimal(pair.getConversationResult())+
                " " +
                pair.getTargetCode();
    }

    private String priceWithoutDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }
}
