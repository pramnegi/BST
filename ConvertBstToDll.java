// Time complexity O(n)
// Space complexity O(height)

class ConvertBstToDll {

	private BST bst;

	ConvertBstToDll() {
		this.bst = new BST();
	}

	public void printDll(BNode node) {
		if(node == null)
			return;
		while(node != null){
			System.out.print(node.getValue() + " ");
			node = node.getRight();	
		}
		System.out.println();
	}

	private BNode[] tuple(BNode node1, BNode node2) {
		return new BNode[]{node1, node2};
	}
	
	

	private void merge(BNode prev, BNode current, BNode next) {
		prev.setRightNode(current);
		current.setLeftNode(prev);
		current.setRightNode(next);
	}

	public BNode[] postOrderTraversal(BNode node) {
		
		if(node.getLeft() == null && node.getRight() == null)
			return tuple(node,node);

		BNode[] tuple1 = new BNode[]{node, node};
		BNode[] tuple2 = new BNode[]{node, node};

		if(node.getLeft() != null)
			tuple1 = postOrderTraversal(node.getLeft());
		if(node.getRight() != null)
			tuple2 = postOrderTraversal(node.getRight());
		
		merge(tuple1[1], node, tuple2[0]);

		return tuple(tuple1[0], tuple2[1]);
	}

	public void convert() {
		if(this.bst.root == null)
			return;
		BNode[] t = postOrderTraversal(this.bst.root);
		this.bst.root = t[0];
		t[1].setRightNode(null);
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
		obj.bst.insert(14);
		obj.bst.insert(15);
		obj.bst.insert(40);
		obj.bst.insert(6);
		obj.bst.insert(20);
		
		obj.convert();
		new ConvertBstToDll().convert();	
	}
}
