package Easy.CinemaRoomManager;

import java.util.Scanner;

public class BuyTicket {
    private int     rows;
    private int     seatPlace;

    public BuyTicket(int rows, int seatPlace) {
        this.rows = rows;
        this.seatPlace = seatPlace;
    }

    int cinema_price(int x) {
        int price;

        price = 10;
        if (!(rows * seatPlace < 61)) {
            if ( x > rows / 2) {
                price = 8;
            }
        }
        System.out.printf("\nTicket price: $%d\n\n", price);
        return price;
    }

    boolean checkLocation(char[][] cinema_place, int buyRow, int buySeat) {
        if (buyRow > rows || buyRow < 1 || buySeat > seatPlace || buySeat < 1) {
            System.out.println("\nWrong input!");
            return false;
        }
        else if (cinema_place[buyRow - 1][buySeat - 1] == 'B') {
            System.out.println("\nThat ticket has already been purchased!");
            return false;
        } else {
            return true;
        }
    }

    void buyTicket(char[][] cinemaSeating, Statics statistics) {
        Scanner scanner = new Scanner(System.in);
        int buyRow;
        int buySeat;

        System.out.println();
        System.out.println("Enter a row number:");
        buyRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        buySeat = scanner.nextInt();
        if (!checkLocation(cinemaSeating, buyRow, buySeat)) {
            buyTicket(cinemaSeating, statistics);
        } else {
            statistics.nowStatistics(cinema_price(buyRow));
            cinemaSeating[buyRow - 1][buySeat - 1] = 'B';
        }
    }
}
