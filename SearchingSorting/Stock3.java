//Time Complexity : O(n)
//Space Complexity : O(1)

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class Stock3 {
    public static int maxProfit(int[] prices) {
        if((prices == null) || (prices.length < 2)) {
            return 0;
        }
    
        int min = prices[0];
        int maxProfit = 0;

        Queue<Integer> queue = new LinkedList<>();
       
        queue.offer(maxProfit);

        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, (prices[i] - min));
            min = Math.min(min, prices[i]);
            queue.offer(maxProfit);
        }

        min = prices[prices.length - 1];
        maxProfit = 0;
        Stack<Integer> stack = new Stack<>();


        for(int i = prices.length - 1; i > -1; i--) {
            maxProfit = Math.max(maxProfit, (min - prices[i]));
            min = Math.max(min, prices[i]);
            stack.push(maxProfit);
        }

        maxProfit = stack.pop() + queue.poll();
        while(!stack.isEmpty()) {
            maxProfit = Math.max(maxProfit, stack.pop() + queue.poll());
        }
        return maxProfit;
    }

    public static void main(String[] argv) {
        int  a = maxProfit(new int[] {7,6,4,3,1,20});
        System.out.println(a);
        //System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
