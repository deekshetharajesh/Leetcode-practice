class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 3) 
        return "";
        String a = strs[0];
        String b = strs[1];
        String c = strs[2];
        char[] d = a.toCharArray();
        char[] e = b.toCharArray();
        char[] f = c.toCharArray();
        StringBuilder result = new StringBuilder();
        int Length = Math.min(d.length, Math.min(e.length, f.length));

        for (int i = 0; i < Length; i++) {
            if (d[i] == e[i] && d[i] == f[i]) {
                result.append(d[i]);
            } else {
                break;
            }
        }
        return result.toString();
    }
}
