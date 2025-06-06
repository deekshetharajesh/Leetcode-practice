class Solution {
    public int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int m = a.length;
        int n = b.length;
        if (n == 0) return 0; 
        for (int i = 0; i <= m - n; i++) {
            if (a[i] == b[0]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (a[i + j] == b[j]) {
                        count++;
                    } else {
                        break; 
                    }
                }
                if (count == n) {
                    return i; 
                }
            }
        }
        return -1;  
    }
}
