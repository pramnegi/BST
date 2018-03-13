import java.util.Stack;
public class IsBinarySearchTree {

	private BST bst;
	public IsBinarySearchTree() {
		this.bst = new BST();
	}

	private bool isBST(BNode node, Stack<BNode> stack) {
		if (node == null) {
            return true;
		}

		while(node != null) {
        	stack.push(node);
        	node = node.getLeft();
        }

		BNode prev = null;
        while(!stack.isEmpty()) {
        	BNode top = stack.pop();
			if(prev != null)
				prev = top;
			else {
				if(prev.getValue() >= top.getValue())
					return false;
				else {
					prev = top;
					if(top.getRight() != null) {
						BNode tempNode = top.getRight();
						while(tempNode != null) {
							stack.push(tempNode);
							tempNode = tempNode.getLeft();
						}
					}
				}
			}
		}
		return true;
	}

	public void isBST() {
		Stack<BNode> stack = new Stack<>();
		bool result = isBST(this.bst.root, stack);
		if(result) {
			System.out.println("Binary Search Tree");
		} else {
			System.out.println("Not a Binary Search Tree");
		}
	}

	/*
	NOTE: If binary tree is having all different values, can go with this solution.
	
	private void isBST(BNode node, Queue<Integer> queue){
		if (node == null)
            return;
        isBST(node.getLeft(), queue);
        queue.offer(node.getValue());
        isBST(node.getRight(), queue);
	}

	public void isBST(){
		Queue<Integer> queue = new LinkedList<>();
		isBST(this.bst.root, queue);
		if(!queue.isEmpty()){
			int previous = queue.poll();
			while(!queue.isEmpty()){
				int current = queue.poll();
				if(current <= previous){
					System.out.println("Not a Binary Search Tree");
					return;
				}
				previous = current;
			}
		}
		System.out.println("Binary Search Tree");
	}
	*/

	public static void main(String[] argv) {
		IsBinarySearchTree obj = new IsBinarySearchTree();
		//obj.bst.insert(-2147483648);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(30);
		obj.bst.insert(20);
		//obj.bst.root.getLeft().getLeft().setValue(30);
		obj.bst.insert(80);
		obj.bst.insert(10);
		obj.bst.insert(50);
		obj.bst.insert(40);
		//obj.bst.root.getLeft().getRight().getRight().setValue(20);
		obj.bst.insert(60);
		
		obj.isBST();
		new IsBinarySearchTree().isBST();				//check for empty binary search tree.
	}
}
