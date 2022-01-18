package Easy.CinemaRoomManager;

public class Statics {
    private int     rows;
    private int     seatPlace;
    private int     allTicket;
    private int     sumBuyTicket;
    private int     currentIncome;
    private int     totalIncome;
    private float   percentage;

    public Statics(int rows, int seatPlace) {
        this.allTicket = rows * seatPlace;
        this.rows = rows;
        this.seatPlace = seatPlace;
    }

    int totalIncomeFunc() {
        int sumMax;

        if (rows * seatPlace < 61) {
            sumMax = 10 * rows * seatPlace;
        } else {
            if (rows % 2 == 0) {
                sumMax = rows / 2 * 10 * seatPlace + rows / 2 * 8 * seatPlace;
            } else {
                sumMax = rows / 2 * 10 * seatPlace + (rows - rows / 2) * 8 * seatPlace;
            }
        }
        return sumMax;
    }

    void initialStatistic() {
        sumBuyTicket = 0;
        currentIncome = 0;
        totalIncome = totalIncomeFunc();
        percentage = (float)sumBuyTicket * 100 / allTicket;
    }

    void nowStatistics(int pricePlus) {
        sumBuyTicket++;
        currentIncome += pricePlus;
        percentage = (float)sumBuyTicket * 100 / allTicket;
    }

    void showStatistics() {
        System.out.println("\nNumber of purchased tickets: " + sumBuyTicket);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.printf("Total income: $%d\n\n", totalIncome);
    }
}
