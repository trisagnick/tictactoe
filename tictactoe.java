public class tictactoe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {
        // Test cases
        System.out.println("Is (1, 1) valid? " + isValidMove(1, 1)); // Should be true
        
        // Simulate a move
        board[1][1] = 'X';
        System.out.println("Is (1, 1) valid after 'X' move? " + isValidMove(1, 1)); // Should be false
        System.out.println("Is (3, 0) valid? " + isValidMove(3, 0)); // Should be false (out of bounds)
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     * Input: Row, Column
     * Output: true if valid, false otherwise.
     */
    static boolean isValidMove(int row, int col) {
        // 1. Boundary Check: Row and column must be between 0 and 2
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            
            // 2. Cell Check: Check if the cell currently contains the empty placeholder
            if (board[row][col] == '-') {
                return true;
            }
        }
        
        // If either check fails, the move is rejected
        return false;
    }
}