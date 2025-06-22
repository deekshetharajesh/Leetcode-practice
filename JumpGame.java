class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false; 
        }
        if (n == 1) {
            return true; 
        }

        int reachable = 0; 
        for (int i = 0; i < n; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
