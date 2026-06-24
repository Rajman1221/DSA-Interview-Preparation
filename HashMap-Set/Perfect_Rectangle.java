/*
In this problem we need to find the vertex given of the rectangle together can form a perfect rectangle or not..
What is perfect rectangle:-
   1.All rectangle together can form a larger rectangle (**remember sqr is also rectangle)
   2.There should be gap between two or many small rectangles.
   3.No overlaps of the rectangle should be there.

So simple thought to check for spaces between smaller rectangles are by calculating area larger formed rectangle and summation of all small rectangles..
To check whether rectangles overlap each other or not is by using HashSet in which we gonna insert each index of the smaller reactangles and remove the 
edge if occurs again..
So atlast we gonna get only 4 edges of the required larger rectangle..
*/
class Solution {
    private void helper(HashSet<List<Integer>>set,int x,int y){
        List<Integer>point=Arrays.asList(x,y);
        if(!set.add(point))set.remove(point);
    }
    public boolean isRectangleCover(int[][] rectangles) {
        int maxX=Integer.MIN_VALUE;
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxY=Integer.MIN_VALUE;
        int tArea=0;
        HashSet<List<Integer>>set=new HashSet<>();
        for(int i[]:rectangles){
            maxX=Math.max(maxX,i[2]);
            minX=Math.min(minX,i[0]);
            minY=Math.min(minY,i[1]);
            maxY=Math.max(maxY,i[3]);
            tArea+=(i[2]-i[0])*(i[3]-i[1]);
            helper(set,i[0],i[1]);
            helper(set,i[0],i[3]);
            helper(set,i[2],i[3]);
            helper(set,i[2],i[1]);
        }
        int reqArea=(maxX-minX)*(maxY-minY);
        return (tArea==reqArea && set.size()==4 &&
               set.contains(Arrays.asList(maxX,maxY))&&
               set.contains(Arrays.asList(maxX,minY))&&
               set.contains(Arrays.asList(minX,minY))&&
               set.contains(Arrays.asList(minX,maxY)));
    }
}
