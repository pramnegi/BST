//TimeComplexity : O(n)
//SpaceComplexity : O(n)

import java.util.Stack;

class KthSmallest {

	public static BNode find(BNode node, int k) {
		
		if(node == null || k < 1)
			return null;

		Stack<BNode> stack = new Stack<>();

		int temp = 0;
		while(node != null) {
			stack.push(node);
			node = node.getLeft();
		}

		while(!stack.isEmpty()) {
			BNode current = stack.pop();
			temp++;
			if(temp == k)
				return current;
			current = current.getRight();
			while(current != null) {
				stack.push(current);
				current = current.getLeft();
			}
		}
		System.out.println();
		return null;
	}

	public static void main(String[] argv) {
		BST bst = new BST();
		bst.insert(7);
		bst.insert(9);
		bst.insert(3);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		
		System.out.println(find(bst.root, 14));				
	}
}
