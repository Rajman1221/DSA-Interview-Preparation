//here we gonna use Breadth first search in order to find number of jumps to reach the last index in the array
//Depth first search won't work here because in case of depth first search we traverse through each element in depth and we gonna have to unnecessary visit the index
//IN CASE of breadth first search we gonna trsverse through breadth wise in the array and keep the mark of the visited array
class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1)return 0;
        Queue<Integer>que=new LinkedList<>();\
      //we will keep the record of visited element
        boolean[]visited=new boolean[n];
      //Hashmap keeps the record of the element and its index
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        que.offer(0);
        visited[0]=true;
        int jump=0;
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                int i=que.poll();
                if(i==n-1)return jump;
                if(i+1<n && !visited[i+1]){
                    que.offer(i+1);
                    visited[i+1]=true;
                }
                if(i-1>=0 && !visited[i-1]){
                    que.offer(i-1);
                    visited[i-1]=true;
                }
                if(map.containsKey(arr[i])){
                    for(int j:map.get(arr[i])){
                        if(!visited[j]){
                            visited[j]=true;
                            que.offer(j);
                        }
                    }
                    map.remove(arr[i]);
                }
            }
            jump++;
        }
        return jump;
    }
}
