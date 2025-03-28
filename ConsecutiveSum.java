public class ConsecutiveSum {
    public static int countConsecutiveSumWays(int n) {
        int count = 0;
        
        // Try all possible sequence lengths k
        for (int k = 1; k * (k + 1) < 2 * n; k++) {
       
                float x = (float)(1.0*n - k*(k+1)/2)/k+1 ;
                System.out.println(x);
                if (x- (int)(x)== 0.0) {   
                    count++;
                }
    
        }
        
        return count;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println("Ways to express " + n + " as sum of consecutive numbers: " + countConsecutiveSumWays(n));
    }
}
