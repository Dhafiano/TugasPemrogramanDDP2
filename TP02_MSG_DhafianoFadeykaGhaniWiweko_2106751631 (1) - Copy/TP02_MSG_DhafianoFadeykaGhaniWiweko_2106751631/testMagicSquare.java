// Dhafiano Fadeyka Ghani Wiweko
// 2106751631
// DDP 2
// TP 2

public class testMagicSquare {
    
    public static void main(String[] args) {

        int n = 0; 
        if (args.length == 1) {
            // Membuat try catch agar input menjadi integer
            try {
                n = Integer.parseInt(args[0]);

                if (n % 2 == 0) {
                    // Membuat argumen agar yang dimasukkan ganjil
                    throw new IllegalArgumentException("Size of square must be odd");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must an integer");
                System.exit(1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Usage: java TestMagicSquare <odd size of square>");
            System.exit(1);
        }

        // Create an object of MagicSquare
        MagicSquare ms = new MagicSquare(n);

        // Print the results
        System.out.println("Magic Square of size " + n + "x" + n + ":\n\n" + ms + "\nMain diagonal sum: " + ms.diagonalSum() + "\nSecondary diagonal sum: " + ms.diagonalSum2() + "\nColumn sum: " + ms.columnSum(0) + "\nRow sum: " + ms.rowSum(n - 1) + "\n");
    }
}
