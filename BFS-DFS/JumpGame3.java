//Basically the problem is trying to say that we have to start from given index 'START' after that we have to reach the index containing '0'
//if possible we gonna return true or else false
//simple intuition of this problem is wew gonna use the concept of depth first search and iterate through each index and reach to the leaves and check each index
//is avialable to visit or not

class Solution {
    int n;
    boolean visited[];
    public boolean canReach(int[] arr, int start) {
        n=arr.length;
      //to keep record of which index we have already visited
        visited=new boolean[n];
        return solve(start,arr);
    }
    private boolean solve(int i,int[]arr){
        if(i>=n || i<0 || visited[i]){
            return false;
        }
        if(arr[i]==0)return true;
        visited[i]=true;
        return solve(i+arr[i],arr)||
            solve(i-arr[i],arr);
    }
}
