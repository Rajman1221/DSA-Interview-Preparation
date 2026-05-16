//same question as the part 1 but the catch here is that we may get duplicate in the array..so we must skip the duplicate and continue the search of minimum
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If duplicates are present at left, mid, and right,
            // we cannot decide which side contains the minimum.
            // So shrink the search space.
            if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
                l++;
                r--;
                continue;
            }

            // Minimum lies in the right half
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                // Minimum could be mid itself or in left half
                r = mid;
            }
        }

        return nums[l];
    }
}
