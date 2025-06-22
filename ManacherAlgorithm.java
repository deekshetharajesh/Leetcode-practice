import java.util.*;

public class ManacherAlgorithm {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder t = new StringBuilder();
        t.append('#');
        for (char c : s.toCharArray()) {
            t.append(c).append('#');
        }
        String processedS = t.toString();

        int n = processedS.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i + 1 + p[i] < n && i - 1 - p[i] >= 0 &&
                   processedS.charAt(i + 1 + p[i]) == processedS.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLen) / 2;
        return s.substring(startIndex, startIndex + maxLen);
    }

    public static void main(String[] args) {
        ManacherAlgorithm solver = new ManacherAlgorithm();
        System.out.println("Input: \"racecar\", Output: \"" + solver.longestPalindrome("racecar") + "\"");
        System.out.println("Input: \"banana\", Output: \"" + solver.longestPalindrome("banana") + "\"");
        System.out.println("Input: \"civiccenter\", Output: \"" + solver.longestPalindrome("civiccenter") + "\"");
        System.out.println("Input: \"noonmadam\", Output: \"" + solver.longestPalindrome("noonmadam") + "\"");
        System.out.println("Input: \"levelheaded\", Output: \"" + solver.longestPalindrome("levelheaded") + "\"");
       
    }
}
