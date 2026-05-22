/*
In this problem, we need to search for a target element in a rotated sorted array.

We use Binary Search because the array is still partially sorted.

At every step:
1. Find the middle element.
2. Check whether the left half is sorted or the right half is sorted.
3. If the sorted half contains the target, move inside that half.
4. Otherwise, search in the other half.

This reduces the search space by half every time.
Time Complexity : O(log n)
Space Complexity : O(1)
*/
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target)return mid;
          //left half sorted
            if(nums[mid]>nums[r]){
                if(target>=nums[l] && nums[mid]>target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else {
                if(target>nums[mid] && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }   
            }
        }
        return -1;
    }
}
