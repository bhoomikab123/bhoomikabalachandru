import java.util.*;

public class rockpaper {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int c = 0;

        while (c <= 3) {

            System.out.println("\nEnter choice: 1-Rock  2-Paper  3-Scissors");
            int choice = sc.nextInt();

            int random = rand.nextInt(3) + 1;
            System.out.println("Computer choice: " + random);

            if (choice == random) {
                System.out.println("Tie");
            } else if ((choice == 1 && random == 3) ||
                    (choice == 2 && random == 1) ||
                    (choice == 3 && random == 2)) {

                // You Win cases
                if (choice == 1 && random == 3) {
                    System.out.println("Yours is Rock, Computer is Scissors");
                } else if (choice == 2 && random == 1) {
                    System.out.println("Yours is Paper, Computer is Rock");
                } else if (choice == 3 && random == 2) {
                    System.out.println("Yours is Scissors, Computer is Paper");
                }

                System.out.println("You Win!");
            } else {

                // Computer Wins cases
                if (choice == 1 && random == 2) {
                    System.out.println("Yours is Rock, Computer is Paper");
                } else if (choice == 2 && random == 3) {
                    System.out.println("Yours is Paper, Computer is Scissors");
                } else if (choice == 3 && random == 1) {
                    System.out.println("Yours is Scissors, Computer is Rock");
                }

                System.out.println("Computer Wins!");
            }

            c++;
        }

        sc.close();
    }
}
