import java.util.*;
public class StringCompressor {

    // First Compressor: Standard RLE
    public static String firstCompressor(String str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count);
        return sb.toString();
    }

    // Second Compressor: Optimize further
   public static String secondCompressor(String compressedStr) {
        if (compressedStr == null || compressedStr.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer,StringBuilder> map = new LinkedHashMap<>();

        int i = 0;
        while (i < compressedStr.length()) {
            char currentChar = compressedStr.charAt(i);
            int j = i + 1;
            StringBuilder num = new StringBuilder();
            // Get the count
            while (j < compressedStr.length() && Character.isDigit(compressedStr.charAt(j))) {
                num.append(compressedStr.charAt(j));
                j++;
            }

            int count = Integer.parseInt(num.toString());

            // If first time, skip the count
            map.putIfAbsent(count, new StringBuilder());
            map.get(count).append(currentChar);

            i = j;
        }

        for (Map.Entry<Integer, StringBuilder> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(entry.getKey());
        }  

        return sb.toString();
    }


    // ------------------ Testing ------------------
    public static void main(String[] args) {
        // Test case 1
        String str1 = "aabcccccaaa";
        String compressed1 = firstCompressor(str1);
        String optimized1 = secondCompressor(compressed1);
        System.out.println("Original: " + str1);
        System.out.println("First Compression: " + compressed1);
        System.out.println("Second Compression: " + optimized1);
        System.out.println();

        // Test case 2
        String str2 = "aabbcaaaccc";
        String compressed2 = firstCompressor(str2);
        String optimized2 = secondCompressor(compressed2);
        System.out.println("Original: " + str2);
        System.out.println("First Compression: " + compressed2);
        System.out.println("Second Compression: " + optimized2);
        System.out.println();

        // Edge case
        String compressed3 = "a20b20c1a4";
        String optimized3 = secondCompressor(compressed3);
        System.out.println("Edge Input: " + compressed3);
        System.out.println("Optimized Output: " + optimized3);
    }
}
