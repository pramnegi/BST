// Time Complexity : O(n)
// Space Complexity : O(n)

//Problem : Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.  

class TrappingRainWater {

    public static int trap(int[] heights) {

        if(heights == null || heights.length < 3)
            return 0;

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int currentMax = 0;
     
        int result = 0;
            
        for(int i = 1; i < heights.length; i++) {
            currentMax = Math.max(currentMax, heights[i - 1]);
            left[i] = currentMax;
        }

        currentMax = 0;
        
        for(int i = heights.length - 2; i >= 0; i--) {
            currentMax = Math.max(currentMax, heights[i + 1]);
            right[i] = currentMax;
        }

        for(int i = 1; i < heights.length - 1; i++) {
            int temp = Math.min(left[i], right[i]);
            result += temp > heights[i] ? temp - heights[i] : 0;
        }

        return result;
    }

    public static void main(String[] argv) {
        System.out.println(trap(new int[] {4,2,0,2,3,5}));
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
        System.out.println(trap(new int[] {0,1,0,1}));
    }
}