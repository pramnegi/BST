// Time Complexity : O(n)
// Space Complexity : O(n)

//Problem : Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.  

class TrappingRainWater {

    public static int trap(int[] height) {

        if (height == null || (height.length <= 2)) {
            return 0;
        }
        
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < height.length; i++){
            max = Math.max(height[i], max);
            leftMax[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        for(int i = height.length - 1; i >= 0; i--){
            max = Math.max(height[i], max);
            rightMax[i] = max;
        }
        
        int maxWater = 0;
        for(int i = 0; i < height.length; i++){
            maxWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return maxWater;
    }

    public static void main(String[] argv) {
        System.out.println(trap(new int[] {4,2,0,2,3,0}));
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
        System.out.println(trap(new int[] {0,1,0,1}));
    }
}
