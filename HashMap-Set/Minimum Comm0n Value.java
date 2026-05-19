/*its an easy marked question on leetcode 
here we simply have to find the minimum common value in the given 2 sorted arrays
for this we gonna use a Hashset to store the elements of the second array and iterate throught the first and when we get the first smallest equal element boom
that our answer
*/

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums2){
            set.add(i);
        }
        for(int i:nums1){
            if(set.contains(i))return i;
        }
        return -1;
    }
}
