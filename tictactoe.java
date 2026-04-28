import java.util.Scanner;
import java.util.Random;

public class tictactoe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Random random = new Random();

    // Print Board
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
    }

    // Convert 1–9 to row & column
    public static int[] convert(int pos) {
        return new int[]{(pos - 1) / 3, (pos - 1) % 3};
    }

    // UC6: Place Move
    public static boolean placeMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = player;
        return true;
    }

    // UC9: Check Win
    public static boolean checkWin(char p) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }

        // Diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;

        return false;
    }

    // Check Draw
    public static boolean isDraw(int moves) {
        return moves == 9;
    }

    // UC7: Computer Random Move
    public static void computerMove() {
        while (true) {
            int pos = random.nextInt(9) + 1; // 1–9
            int[] rc = convert(pos);

            if (placeMove(rc[0], rc[1], 'O')) {
                System.out.println("Computer chose position: " + pos);
                break;
            }
        }
    }

    // Main (UC8: Game Loop)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int moves = 0;
        boolean gameOver = false;

        System.out.println("=== Tic Tac Toe ===");

        while (!gameOver) {

            printBoard();

            // Player Move
            System.out.print("\nEnter position (1-9): ");
            int pos = sc.nextInt();

            int[] rc = convert(pos);

            if (!placeMove(rc[0], rc[1], 'X')) {
                System.out.println("❌ Invalid move! Try again.");
                continue;
            }

            moves++;

            // Check Player Win
            if (checkWin('X')) {
                printBoard();
                System.out.println("🎉 You Win!");
                break;
            }

            // Check Draw
            if (isDraw(moves)) {
                printBoard();
                System.out.println("It's a Draw!");
                break;
            }

            // Computer Move
            computerMove();
            moves++;

            // Check Computer Win
            if (checkWin('O')) {
                printBoard();
                System.out.println("💻 Computer Wins!");
                break;
            }

            // Check Draw
            if (isDraw(moves)) {
                printBoard();
                System.out.println("It's a Draw!");
                break;
            }
        }

        sc.close();
        System.out.println("\nGame Over!");
    }
}