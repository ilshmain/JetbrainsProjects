package Easy.CoffeeMachine;
import java.util.Scanner;

public class Main {

    public static void showStateIngridients(Ingridient ingridient) {
        System.out.println("The coffee machine has:");
        System.out.println(ingridient.waterMachine + " ml of water");
        System.out.println(ingridient.milkMachine + " ml of milk");
        System.out.println(ingridient.beansMachine + " g of coffee beans");
        System.out.println(ingridient.cupsMachine + " disposable cups");
        System.out.println("$" + ingridient.moneyMachine + " of money");
    }

    public  static void initialIngridients() {
        Scanner scanner = new Scanner(System.in);
        String action;

        Ingridient ingridient = new Ingridient(400, 540, 120, 9, 550);
        BuyCoffee buy = new BuyCoffee();
        FillMachine fill = new FillMachine();
        TakeMoney take = new TakeMoney();

        for (;;) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            switch (action) {
                case "buy" : buy.buyCoffee(ingridient,scanner);
                    break;
                case "fill" : fill.fillMachine(ingridient, scanner);
                    break;
                case "take" : take.takeMoney(ingridient);
                    break;
                case "remaining" : showStateIngridients(ingridient);
                    break;
                case "exit" : return;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initialIngridients();
    }
}
