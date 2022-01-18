package Easy.CinemaRoomManager;
import java.util.Scanner;

public class Main {

    static void printMenu(Scanner scanner, int rows, int seatPlace) {
        int     numberMenu;
        char    [][] seatsHall;

        CinemaHall hallOne = new CinemaHall(rows, seatPlace);
        Statics statistics = new Statics(rows,seatPlace);
        BuyTicket buy = new BuyTicket(rows, seatPlace);
        statistics.initialStatistic();
        seatsHall = hallOne.cinemaInitialization();

        for (;;) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            numberMenu = scanner.nextInt();
            switch (numberMenu) {
                case 1 : hallOne.showCinemaPlace(seatsHall);
                    break;
                case 2: buy.buyTicket(seatsHall, statistics);
                    break;
                case 3: statistics.showStatistics();
                    break;
                case 0 : return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int     rows;
        int     seatPlace;

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatPlace = scanner.nextInt();
        System.out.println();

        printMenu(scanner, rows, seatPlace);
    }
}
