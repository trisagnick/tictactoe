import java.util.Scanner;

public class tictactoe {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int slot = getUserInput();
        System.out.println("You selected slot: " + slot);
    }

    // UC3: Get user input
    public static int getUserInput() {
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }
}