package Easy.CinemaRoomManager;

public class CinemaHall {

    private int rows;
    private int seatPlace;
    private char[][] cinemaPlace;

    public CinemaHall(int rows, int seatPlace) {
        this.rows = rows;
        this.seatPlace = seatPlace;
    }

    char[][] cinemaInitialization() {
        cinemaPlace = new char[rows][seatPlace];

        for (int i = 0; i < rows; i++) {
            for (int q = 0; q < seatPlace; q++) {
                cinemaPlace[i][q] = 'S';
            }
        }
        return cinemaPlace;
    }

    void showCinemaPlace(char[][] cinema_place) {
        int i;
        int q;
        int line;
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";

        line = 1;
        System.out.println("\nCinema:");
        for (i = 1; i <= seatPlace; i++) {
            if (i == 1) {
                System.out.print("  " + i);
            } else {
                System.out.print(" " + i);
            }
        }
        System.out.println();
        for (i = 0; i < rows; i++) {
            System.out.print(line);
            for (q = 0; q < seatPlace; q++) {
                if (cinema_place[i][q] == 'B') {
                    System.out.print(" "+ ANSI_CYAN + cinema_place[i][q] + ANSI_RESET);
                } else {
                    System.out.print(" "+ cinema_place[i][q]);
                }
            }
            line++;
            System.out.println();
        }
        System.out.println();
    }
}
