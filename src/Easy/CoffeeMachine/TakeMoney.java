package Easy.CoffeeMachine;

public class TakeMoney {

    public void takeMoney(Ingridient ingridient) {
        System.out.println("I gave you $" + ingridient.moneyMachine);
        ingridient.moneyMachine = 0;
    }
}
