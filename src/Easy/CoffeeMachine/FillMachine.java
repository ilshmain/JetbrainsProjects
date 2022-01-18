package Easy.CoffeeMachine;

import java.util.Scanner;

public class FillMachine {

    public void addIngridients(Ingridient ingridientMachine, Ingridient add) {
        ingridientMachine.waterMachine += add.waterMachine;
        ingridientMachine.milkMachine += add.milkMachine;
        ingridientMachine.beansMachine += add.beansMachine;
        ingridientMachine.cupsMachine += add.cupsMachine;
    }

    public void fillMachine(Ingridient ingridient, Scanner scanner) {
        int water;
        int milk;
        int beans;
        int cups;
        Ingridient addIngridient;

        System.out.println("\nWrite how many ml of water you want to add:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups = scanner.nextInt();
        addIngridient = new Ingridient(water, milk, beans, cups, 0);
        addIngridients(ingridient, addIngridient);
    }
}
