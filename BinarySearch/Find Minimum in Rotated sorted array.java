//this is problem where we are given with an rotated sorted array where we have to find minimum element in O(logn)..
//so we gonna use Binary search method as the array is sorted.
//there must be a point in the array from where its rotated, that means we have two separated sorted half left half and right half
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            //here we check that the left half is sorted or not (matlb agar nums[mid]>nums[r] hai toh mid ke baad saare chote element hai )right side of the mid 
            //we will get our ans..
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}
