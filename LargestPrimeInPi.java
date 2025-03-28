

public class LargestPrimeInPi {
    public static void main(String[] args) {
        // First 100 digits of Pi (excluding decimal point)
        String piDigits = 
            "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        int maxPrime = 0;

        // Iterate through all 5-digit substrings
        for (int i = 0; i <= piDigits.length() - 5; i++) {
            String sub = piDigits.substring(i, i + 5);
            int num = Integer.parseInt(sub);

            // Check if the number is prime
            if (isPrime(num)) {
                maxPrime = Math.max(maxPrime, num);
            }
        }

        // Print the largest prime found
        System.out.println("Largest 5-digit prime in first 100 digits of Pi: " + maxPrime);
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int i = 2; i  <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
