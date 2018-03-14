// Time complexity O(n)
// Space complexity O(n)

import java.util.Queue;
import java.util.LinkedList;

class ConvertBstToDll {
	
	private BST bst;

	ConvertBstToDll() {
		this.bst = new BST();
	}

	public void printDll(BNode node) {
		if(node == null)
			return;
		while(node != null){
			//System.out.println(node.getLeft() + " " + node.getValue() + " " + node.getRight());
			System.out.print(node.getValue() + " ");
			node = node.getRight();	
		}
		System.out.println();
	}

	public void inOrderTraversal(BNode node, Queue<BNode> queue) {
		
		if(node == null)
			return;

		inOrderTraversal(node.getLeft(), queue);
		queue.offer(node);
		inOrderTraversal(node.getRight(), queue);
	}

	public void convert() {

		Queue<BNode> queue = new LinkedList<BNode>();

		if(this.bst.root == null)
			return;

		inOrderTraversal(this.bst.root, queue);

		//Convert BinarySearchTree to Doubly LinkedList.
		BNode currentNode = queue.poll();
		this.bst.root = currentNode;
		currentNode.setLeftNode(null);
		BNode prevNode = currentNode;

		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			prevNode.setRightNode(currentNode);
			currentNode.setLeftNode(prevNode);
			prevNode = currentNode;
		}
		prevNode.setRightNode(null);

		//print Doubly LinkedList.
		printDll(this.bst.root);

	}

	public static void main(String[] argv) {
		ConvertBstToDll obj = new ConvertBstToDll();
		obj.bst.insert(7);
		obj.bst.insert(9);
		obj.bst.insert(3);
		obj.bst.insert(2);
		obj.bst.insert(8);
		obj.bst.insert(1);
		obj.bst.insert(5);
		obj.bst.insert(4);
		obj.bst.insert(6);
		
		obj.convert();
		new ConvertBstToDll().convert();	
	}
}