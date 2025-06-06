import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int c = nums[0];  
        for (int i = 0; i < n; i++) {
            count = 0;  // reset count for each new i
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > n / 2) {
                c = nums[i];
                break;
            }
        }

        return c;
    }
}
