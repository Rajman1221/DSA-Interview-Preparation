/*In this problem we need to find the nearest 0 to the given point in the matrix...
for this we gonna use BFS appraoch as we already know that to find the maximum or minimum knid of problem we use BFS approach...
But the think to be noted that we must use multiple source bfs appraoch for this..
Steps are-
  first we gonna insert all the source point in the queue i.e(all the block containing 0) and mark other block as-1(not visited)..
  Secondly we gonna pop all the block and the block with 0 we gonna skip it and block with val -1 we gonna calculate dist..
  Distance of neighbor = distance of current + 1
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]>que=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)que.offer(new int[]{i,j});
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                int curr[]=que.poll();
                for(int[]d:dir){
                    int newr=d[0]+curr[0];
                    int newc=d[1]+curr[1];
                    while(newr>=0 && newr<m && newc>=0 && newc<n && mat[newr][newc]==-1){
                        mat[newr][newc]=mat[curr[0]][curr[1]]+1;
                        que.offer(new int[]{newr,newc});
                    }
                }
            }
        }
        return mat;
    }
}
