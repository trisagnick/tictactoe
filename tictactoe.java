import java.util.Scanner;
import java.util.Random;

public class tictactoe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Random random = new Random();

    // Display board
    public static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    // Convert slot (1–9) to row & column
    public static int[] convertPosition(int pos) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        return new int[]{row, col};
    }

    // UC6: Place move
    public static boolean placeMove(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = symbol;
        return true;
    }

    // UC7: Computer random move
    public static void computerMove() {
        int pos;
        int row, col;

        // Loop until valid move found
        while (true) {
            pos = random.nextInt(9) + 1; // 1–9
            int[] rc = convertPosition(pos);
            row = rc[0];
            col = rc[1];

            if (placeMove(row, col, 'O')) {
                System.out.println("\nComputer chose position: " + pos);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        System.out.println("=== Tic Tac Toe (You vs Computer) ===");

        while (moves < 9) {

            // Human turn
            printBoard();
            System.out.print("\nEnter position (1-9): ");
            int pos = scanner.nextInt();

            int[] rc = convertPosition(pos);
            if (placeMove(rc[0], rc[1], 'X')) {
                moves++;
            } else {
                System.out.println("❌ Invalid move! Try again.");
                continue;
            }

            if (moves >= 9) break;

            // Computer turn
            computerMove();
            moves++;
        }

        printBoard();
        System.out.println("\nGame Over!");
        scanner.close();
    }
}