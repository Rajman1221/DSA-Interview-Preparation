//same problem as previous but now we gonna use bfs approach to solve this problem..
//simply we gonna maintain a visited array and queue which will iterate us through the array in bfs manner...
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean visited[]=new boolean[n];
        Queue<Integer>que=new LinkedList<>();
        que.offer(start);
        while(!que.isEmpty()){
            int i=que.poll();
            if(i<0 || i>=n || visited[i])continue;
            if(arr[i]==0)return true;
            visited[i]=true;
            que.offer(i+arr[i]);
            que.offer(i-arr[i]);
        }
        return false;
    }
}
