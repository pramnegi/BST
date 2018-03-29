// Time Complexity : O(n)
// Space Complexity : O(n)

//Problem : Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 

import java.util.Stack;

class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0)
            return 0;

        if(heights.length == 1)
            return heights[0];
        
        int max = 0;

        /*for(int row = 0; row < heights.length; row++) {

            int min = Integer.MAX_VALUE;

            for(int column = 0; column < heights.length - row; column++) {
                min = Math.min(min, heights[row+column]);
                if(min * (column + 1) > max)
                    max = min * (column + 1);
            }
        }*/

        Stack<Integer> stack = new Stack<Integer>();
    
        int i = 0;
            
        while(i < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i);
                i++;
            }
            else if(heights[stack.peek()] == heights[i]) {
                stack.pop();
                stack.push(i);
                i++;
                continue;
            }
            else {
                int temp = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1 ;
                max = Math.max(max, heights[temp]*w); 
            }

        }
        
        while(!stack.isEmpty()) {
                int temp = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek()-1;
                max = Math.max(max, heights[temp]*w); 
        }

        /*
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
       
        stack.push(-1);
        for(int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            while((stack.peek() != - 1) && (heights[stack.peek()] >= heights[i])) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
        }
        stack.push(i);
        }
        int rightMost = stack.peek();
        
        while(stack.peek() != - 1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (rightMost - stack.peek()));
        }
        */
        return max;
    }

    public static void main(String[] argv) {
        System.out.println(largestRectangleArea(new int[] {4,2,0,2,3,5})+ " ans : "+6);
        System.out.println(largestRectangleArea(new int[] {4,2,0,3,2,5})+ " ans : "+6);
        System.out.println(largestRectangleArea(new int[] {0,1,0,1}) + " ans : "+1);
    }
}