import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix size
        System.out.print("Enter the size of matrices (n): ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n]; // Result matrix

        // Input matrix A
        System.out.println("Enter matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Input matrix B
        System.out.println("Enter matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        // Multiply matrices A and B, store result in C
        for (int i = 0; i < n; i++) {          // Row of A
            for (int j = 0; j < n; j++) {      // Column of B
                C[i][j] = 0;                   // Initialize result cell
                for (int k = 0; k < n; k++) {  // Iterate through row of A & column of B
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Print result matrix C
        System.out.println("Resultant Matrix (A x B):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
