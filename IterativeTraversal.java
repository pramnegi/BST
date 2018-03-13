import java.util.*;
class IterativeTraversal {
	
	private BST bst;
	IterativeTraversal() {
		this.bst = new BST();
	}

	public void preOrderTraversal() {
		if(this.bst.root == null) {
			return;
		}
		
		Stack<BNode> stack = new Stack<BNode>();
		stack.push(this.bst.root);
		
		while(!stack.isEmpty()) {
			BNode top = stack.pop();
			System.out.print(top.getValue() + " ");

			if(top.getRight() != null) {
				stack.push(top.getRight());
			}
			if(top.getLeft() != null) {
				stack.push(top.getLeft());
			}
		}
		System.out.println();
	}

	public void inOrderTraversal() {
    Stack<BNode> stack = new Stack<BNode>();
    if(this.bst.root == null)
        return;
    BNode current = this.bst.root;

    // while(current != null) {  
    //     stack.push(current);
    //     current = current.getLeft();
    // } 
  
    // while(!stack.isEmpty()){
    //     current = stack.pop();
    //     System.out.print(current.getValue() + " ");
    //     if(current.getRight() != null) {
    //         current = current.getRight();
    //         while(current != null) {
    //             stack.push(current);
    //             current = current.getLeft();
    //          }
    //     }
    // }

    while(!stack.isEmpty() || (current != null)) {
        if(current != null) {
            stack.push(current);
            current = current.getLeft();
        } else {
            current = stack.pop();
            System.out.print(current.getValue() + " ");
            current = current.getRight();
        }
    }

    System.out.println();
}

	public void levelTraversal() {
		if(this.bst.root == null) {
			return;
		}
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.offer(this.bst.root);
		while(!queue.isEmpty()) {
			BNode top = queue.poll();
			System.out.print(top.getValue() + " ");
			if(top.getLeft() != null)
				queue.add(top.getLeft());
			if(top.getRight() != null)
				queue.add(top.getRight());
			
		}
		System.out.println();
	}

	public static void main(String[] argv){

		IterativeTraversal obj = new IterativeTraversal();
		obj.bst.insert(40);
		obj.bst.insert(10);
		obj.bst.insert(70);
		obj.bst.insert(50);
		obj.bst.insert(20);
		obj.bst.insert(30);
		obj.bst.insert(80);
		System.out.print("PreOrder Traversal : ");
		obj.preOrderTraversal();
		System.out.print("inOrder Traversal : ");
		obj.inOrderTraversal();
		System.out.print("LevelOrder Traversal : ");
		obj.levelTraversal();
		//new IterativeTraversal().preOrderTraversal();				//check for empty binary search tree.
	}
}
