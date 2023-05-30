// Dhafiano Fadeyka Ghani Wiweko
// 2106751631
// DDP 2 A
// TP 2

public class MagicSquare {
    private int[][] kotak;
    private int size;

    /**
     * Construct a MagicSquare object (precondition: s is odd).
     *
     * @param s the size of the square
     */
    public MagicSquare(int s) {
        size = s;
        kotak = new int[size][size];

        int row = size - 1;
        int column = size / 2;
        kotak[row][column] = 1;

        for (int i = 2; i <= size * size; i++) {
            int nextRow = (row + 1) % size;
            int nextCol = (column + 1) % size;
            if (kotak[nextRow][nextCol] != 0) {
                nextRow = (row - 1 + size) % size;
                nextCol = column;
            }
            kotak[nextRow][nextCol] = i;
            row = nextRow;
            column = nextCol;
        }
    }

    /**
     * Find the sum of the diagonal from the top-left to the bottom-right corner.
     *
     * @return the sum of the diagonal
     */
    public int diagonalSum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += kotak[i][i];
        }
        return sum;
    }

    /**
     * Find the sum of the diagonal from the top-right to the bottom-left corner.
     *
     * @return the sum of the diagonal
     */
    public int diagonalSum2() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += kotak[i][size - i - 1];
        }
        return sum;
    }

    /**
     * Add the numbers in a column of the square.
     *
     * @param i the column index
     * @return the sum of the column
     */
    public int columnSum(int i) {
        int sum = 0;
        for (int j = 0; j < size; j++) {
            sum += kotak[j][i];
        }
        return sum;
    }

    /**
     * Add the numbers in a row of the square.
     *
     * @param i the row index
     * @return the sum of the row
     */
    public int rowSum(int i) {
        int sum = 0;
        for (int j = 0; j < size; j++) {
            sum += kotak[i][j];
        }
        return sum;
    }

    /**
     * Gets a string representation of the contents of this square.
     *
     * @return a string representation of the square
     */
    public String toString() {
        String r = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                r += kotak[i][j] + "\t";
            }
            r += "\n";
        }
        return r;
    }
}
