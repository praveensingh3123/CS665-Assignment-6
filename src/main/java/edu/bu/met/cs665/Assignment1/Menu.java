package edu.bu.met.cs665.Assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu{
    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        double totalBeveragePrice = 0;
        Map<String, MakeBeverage> menu = new HashMap<>();
        menu.put("Espresso", new Espresso());
        menu.put("Americano", new Americano());
        menu.put("Latte Macchiato", new LatteMacchiato());
        menu.put("Black Tea", new BlackTea());
        menu.put("Green Tea", new GreenTea());
        menu.put("Yellow Tea", new YellowTea());
        do {
            System.out.println("Please choose your drink or enter C to checkout.");
            System.out.println();
            System.out.println("1. Espresso");
            System.out.println("2. Americano");
            System.out.println("3. Latte Macchiato");
            System.out.println("4. Black Tea");
            System.out.println("5. Green Tea");
            System.out.println("6. Yellow Tea");
            System.out.println("C. Checkout");
            String[] menuList = {"Espresso", "Americano", "Latte Macchiato", "Black Tea", "Green Tea", "Yellow Tea"};
            String userChoice = "";
            char userInput = sc.next().charAt(0);
            if(userInput-'1' < 7){
                userChoice = menuList[userInput - '1'];
            }else if(userInput== 'C'){
                System.out.print("Your total is: " + totalBeveragePrice);
                return;
            }
            else{
                System.out.println("Please enter a valid input.");
                continue;
            }

            if (menu.containsKey(userChoice)) {
                menu.get(userChoice).makeBeverage();
                totalBeveragePrice += Price.beveragePrice;
                Condiment.addCondiment(totalBeveragePrice);
                return;
            }
        } while (true);
    }
}
