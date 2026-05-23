/*Here we hava to check whether the given array is rotated and sorted or not ...
for the brute force approach we gonna check for each rotation whether in thaat rotation the array is sorted or not ..
if its not sorted then we gonna return false else true..
*/class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        // Try every rotation
        for (int k = 0; k < n; k++) {

            boolean sorted = true;

            // Check if current rotation is sorted
            for (int i = 0; i < n - 1; i++) {

                int curr = nums[(i + k) % n];
                int next = nums[(i + 1 + k) % n];

                if (curr > next) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) return true;
        }

        return false;
    }
}
/*
The optimal appraoch for this problem is sexy here as we know that the array is sorted and rotated ...
so here we gonna find the peak point from where the array is rotated ..
if we get more than one peak point then we gonna return false..
else true..
*/
class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int peak=0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n])peak++;
        }
        return (peak<=1);
    }
}
