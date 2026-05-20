/*
Basically, this question asks us to find the number of common elements
between both arrays from index 0 to i.

We iterate through each index and check whether the elements in both arrays
are equal or not.

- If A[i] == B[i], then we found one common element, so we increment count.

- We use a HashSet to store previously visited elements from both arrays.

- If A[i] was already seen earlier in B, it means it is now common,
  so we increment count.

- Similarly, if B[i] was already seen earlier in A, we increment count.

Finally, we store the count at every index in the result array.
*/ 
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int res[]=new int[n];
        int count=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(A[i]==B[i]){
                count++;
            }
            else {
                if(set.contains(A[i]))count++;
                if(set.contains(B[i]))count++;
            }
            set.add(A[i]);
            set.add(B[i]);
            res[i]=count;
        }
        return res;
    }
}
