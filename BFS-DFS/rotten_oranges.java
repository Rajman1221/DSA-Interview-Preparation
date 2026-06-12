/* In this problem we need to find the minimum minutes required to rotten all the avialable oranges in the grid....
   So the we gonna in way that oranges adjacent to rotten will rotten simultaneously all the adjacent oranges get rotten...
   So here we wil use BFS approach to solve the problem (WHY NOT DFS??? reason is that we are asked to find the min/max so best approach is bfs)..
   But here one catch is that in every minutes many oranges can get rotten together ,so here we cant take one source (one rotten oranges at a time)..
   so here we will MULTIPLE SOURCE BFS where all the rotten oranges will be chech together to find the best possible way to find minimum minutes to rotten 
   oranges...
   We gonna mark the oranges that got rotten after each minutes and also decrease the count of the fresh oranges..
   if fresh oranges==0 all oranges got rotten else fresh oranges are remaining..
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>que=new LinkedList<>();
        int fhorngs=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              //adding all the sources (rotten oranges)
                if(grid[i][j]==2)que.offer(new int[]{i,j});
              //keeping count of fresh oranges
                if(grid[i][j]==1)fhorngs+=1;
            }
        }
        if(fhorngs==0)return 0;
        int min=0;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                int curr[]=que.poll();
                int x=curr[0];
                int y=curr[1];
                for(int d[]:dir){
                    int newx=d[0]+x;
                    int newy=d[1]+y;
                    if(newx>=0 && newx<m && newy>=0 && newy<n && grid[newx][newy]==1){
                        //marking oranges once get rotten
                        grid[newx][newy]=2;
                        que.offer(new int[]{newx,newy});
                      //decrease the count of fresh oranges
                        fhorngs--;
                    }
                }
            }
            min++;
        }
        return (fhorngs==0)?min-1:-1;
    }
}
