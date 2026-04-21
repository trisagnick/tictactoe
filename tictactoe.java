import java.util.Scanner;

public class tictactoe {

    // Board declaration
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Display the board
    public static void printBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    // UC6: Place Move on Board
    public static boolean placeMove(int row, int col, char symbol) {

        // Check if position is valid
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("❌ Invalid position! Use 0, 1, or 2.");
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != ' ') {
            System.out.println("❌ Cell already occupied!");
            return false;
        }

        // Place the symbol (State Update)
        board[row][col] = symbol;
        return true;
    }

    // Main method (REQUIRED)
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        int moves = 0;

        System.out.println("=== Tic Tac Toe ===");

        while (moves < 9) {

            printBoard();

            System.out.println("\nPlayer " + currentPlayer + "'s turn");

            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            // Try placing move
            if (placeMove(row, col, currentPlayer)) {
                moves++;

                // Switch player
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }

        printBoard();
        System.out.println("\nGame Over!");
        scanner.close();
    }
}