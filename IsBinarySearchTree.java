import java.util.Stack;
public class IsBinarySearchTree{

	private BST bst;
	IsBinarySearchTree(){
		bst = new BST();
	}

	private void isBST(BNode node, Stack<BNode> stack){
		if (node == null){
			System.out.println("Empty Tree");
            return;
		}
        stack.push(node);
        node = node.getLeft();
        while(node != null){
        	stack.push(node);
        	node = node.getLeft();
        }
        while(!stack.isEmpty()){
        	BNode top = stack.pop();
        	if(top.getRight() != null || top.getLeft() != null){
        		if(top.getRight() != null && top.getLeft() != null){
        			if(top.getLeft().getValue() >= top.getValue() || top.getRight().getValue() < top.getValue()){
        				System.out.println("Not a Binary Search Tree");
        				return;
        			}
        		}
        		if(top.getLeft() != null && top.getLeft().getValue() >= top.getValue()){
        			System.out.println("Not a Binary Search Tree");
        			return;
        		}
        		if(top.getRight() != null && top.getRight().getValue() < top.getValue()){
        			System.out.println("Not a Binary Search Tree");
        			return;
        		}
        	}
        	if(top.getRight() != null){
        		node = top.getRight();
        		while(node.getLeft() != null){
        			stack.push(node.getLeft());
        			node = node.getLeft();
        		}
        	}
        }
        System.out.println("Binary Search Tree");
	}

	public void isBST(){
		Stack<BNode> stack = new Stack<>();
		isBST(this.bst.root, stack);
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

	public static void main(String[] argv){
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