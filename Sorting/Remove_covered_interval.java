class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->
        a[0]==b[0] ?b[1]-a[1]:a[0]-b[0]
        );
        ArrayList<int[]>list=new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = list.get(list.size() - 1);
            // Current interval is NOT covered
            if (intervals[i][1] > curr[1]) {
                list.add(intervals[i]);
            }
        }
        return list.size();
    }
}
