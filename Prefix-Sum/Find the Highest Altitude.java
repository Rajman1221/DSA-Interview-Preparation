/*
In this problem we have to find the highest altitude basically we need to find the highest possible number we get while traversing entire array..
So basically we gonna use prefixSum array technique to solve this problem..
Where we gonna calculate the sum and compare the with a max variable which is greater among them..
and we gonna return the max..

TC:-O(n)
Sc:-O(1)
*/
class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int res=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gain[i];
            res=Math.max(res,sum);
        }
        return res;
    }
}
