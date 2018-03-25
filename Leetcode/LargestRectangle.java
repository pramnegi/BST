// Time Complexity : O(n^2)
// Space Complexity : O(1)

//Problem : Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 

class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0)
            return 0;

        if(heights.length == 1)
            return heights[0];
        
        int max = 0;

        for(int row = 0; row < result.length; row++) {

            int min = Integer.MAX_VALUE;

            for(int column = 0; column < result.length - row; column++) {
                min = Math.min(min, heights[row+column]);
                if(min * (column + 1) > max)
                    max = min * (column + 1);
            }
        }

        return max;
    }

    public static void main(String[] argv) {
        System.out.println(largestRectangleArea(new int[] {19816,19817,19818}));
    }
}