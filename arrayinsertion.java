class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums1[i]==nums2[j])
                {
                     if (!list.contains(nums1[i])) {
                        list.add(nums1[i]); // Avoid duplicates
                    }
                    break; 
                }
                
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
