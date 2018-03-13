// Time Complexity : O(n)
// Space Complexity : O(height)

import java.util.Queue;
import java.util.LinkedList;

class LeastCommonAncestor {

	private BST bst;
	LeastCommonAncestor() {
		this.bst = new BST();
	}

	public Boolean parentNode(BNode node, int value, Queue<BNode> queue) {
		if(node == null)
			return false;
		else if(node.getValue() == value){
			queue.offer(node);
			return true;
		}
		else {
			if (parentNode(node.getLeft(), value, queue) || parentNode(node.getRight(), value, queue)) {
				queue.offer(node);
				return true;
			}	
		}
		return false;
	}

	public BNode leastCommonAncestor(int value1, int value2) {
		
		Queue<BNode> queue1 = new LinkedList<>();
		Queue<BNode> queue2 = new LinkedList<>();
		
		parentNode(this.bst.root, value1, queue1);
		parentNode(this.bst.root, value2, queue2);
		
		int temp = Math.abs(queue1.size() - queue2.size());

		if(queue1.size() > queue2.size()) {
			for(int i = 0; i < temp; i++)
				queue1.poll();
		}
		else if(queue1.size() < queue2.size()) {
			for(int i = 0; i < temp; i++)
				queue2.poll();
		}

		while(!queue1.isEmpty()) {
			BNode top1 = queue1.poll();
			BNode top2 = queue2.poll();
			if(top1 == top2) {
				System.out.println(top1.getValue());
				return top1;
			}
		}
		System.out.println("No Common Ancestor");
		return null;
	}

	public static void main(String[] argv) {
		LeastCommonAncestor obj = new LeastCommonAncestor();
		obj.bst.insert(7);
		obj.bst.insert(9);
		obj.bst.insert(3);
		obj.bst.insert(12);
		obj.bst.insert(20);
		obj.bst.insert(2);
		obj.bst.insert(8);
		obj.bst.insert(1);
		obj.bst.insert(5);
		obj.bst.insert(4);
		obj.bst.insert(6);
		
		obj.leastCommonAncestor(9, 20);
		new LeastCommonAncestor().leastCommonAncestor(5, 6);				
	}
}
