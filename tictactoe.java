public class tictactoe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        initializeBoard(board);
        printBoard(board);
    }

    // Initialize board with '-'
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Move to next row
        }
    }
}