class Solution {
    public boolean isAnagram(String s, String t) {
        s=s.replaceAll("\\s","");
        t=t.replaceAll("\\s","");
        if(s.length()!=t.length())
        {
            return false;
        }
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
       
    }
}
