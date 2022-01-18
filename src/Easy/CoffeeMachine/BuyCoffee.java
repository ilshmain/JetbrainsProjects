package Easy.CoffeeMachine;

import java.util.Scanner;

public class BuyCoffee {

    public boolean checkEnoughIngridient(int allValue, int oneValue, String name) {
        if (allValue - oneValue >= 0) {
            return true;
        } else {
            System.out.println("Sorry, not enough " + name + "!");
            return false;
        }
    }

    public void createCoffee(Coffee title, Ingridient ingridient) {

        if (!checkEnoughIngridient(ingridient.waterMachine, title.water, "water"))
            return;
        if (!checkEnoughIngridient(ingridient.milkMachine, title.milk, "milk"))
            return;
        if (!checkEnoughIngridient(ingridient.beansMachine, title.beans, "coffee beans"))
            return;
        if (!checkEnoughIngridient(ingridient.cupsMachine, 1, "cups"))
            return;

        System.out.println("I have enough resources, making you a coffee!");
        ingridient.moneyMachine += title.money;
        ingridient.beansMachine -= title.beans;
        ingridient.milkMachine -= title.milk;
        ingridient.waterMachine -= title.water;
        ingridient.cupsMachine--;
    }

    public void buyCoffee(Ingridient ingridient, Scanner scanner) {
        int     numberCoffee;
        String  str;

        Coffee espresso = new Coffee("espresso", 250, 0, 16, 4);
        Coffee latte = new Coffee("latte", 350, 75, 20, 7);
        Coffee cappuccino = new Coffee("cappuccino", 200, 100, 12, 6);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        str = scanner.next();
        if (str.equals("back")) {
            return;
        }
        numberCoffee = Integer.parseInt(str);
        switch (numberCoffee) {
            case 1 : createCoffee(espresso, ingridient);
                break;
            case 2 : createCoffee(latte, ingridient);
                break;
            case 3 : createCoffee(cappuccino, ingridient);
        }
    }
}
