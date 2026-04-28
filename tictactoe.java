import java.util.Random;
import java.util.Scanner;

public class tictactoe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static Random random = new Random();

    // Print board
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
    }

    // Convert 1–9 to row/col
    public static int[] convert(int pos) {
        return new int[]{(pos - 1) / 3, (pos - 1) % 3};
    }

    // Place move (UC6)
    public static boolean placeMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = player;
        return true;
    }

    // Check win
    public static boolean checkWin(char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true;
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true;
        }
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    // Check draw
    public static boolean isDraw(int moves) {
        return moves == 9;
    }

    // Computer move (UC7)
    public static void computerMove() {
        while (true) {
            int pos = random.nextInt(9) + 1;
            int[] rc = convert(pos);
            if (placeMove(rc[0], rc[1], 'O')) {
                System.out.println("Computer chose: " + pos);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int moves = 0;
        boolean gameOver = false;

        System.out.println("=== Tic Tac Toe ===");

        while (!gameOver) {

            printBoard();

            // Player turn
            System.out.print("\nEnter position (1-9): ");
            int pos = sc.nextInt();
            int[] rc = convert(pos);

            if (!placeMove(rc[0], rc[1], 'X')) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            moves++;

            // Check win
            if (checkWin('X')) {
                printBoard();
                System.out.println("🎉 You win!");
                gameOver = true;
                break;
            }

            // Check draw
            if (isDraw(moves)) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Computer turn
            computerMove();
            moves++;

            // Check win
            if (checkWin('O')) {
                printBoard();
                System.out.println("💻 Computer wins!");
                gameOver = true;
                break;
            }

            // Check draw
            if (isDraw(moves)) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
        }

        sc.close();
    }
}