public class IsBinarySearchTree{

	private BST bst;
	IsBinarySearchTree(){
		bst = new BST();
	}

	private boolean isBST(BNode node, int min, int max){
		if(node == null)
			return true;
		if(node.getValue() <= min || max <= node.getValue())
			return false;
		return isBST(node.getLeft(), min, node.getValue()) && isBST(node.getRight(), node.getValue()-1, max) ;
	}

	public void isBST(){
		if(isBST(this.bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Binary search tree");
		else
			System.out.println("Not a Binary search tree");
	}


	public static void main(String[] argv){
		IsBinarySearchTree obj = new IsBinarySearchTree();
		BNode node = new BNode(20);
		obj.bst.insert(70);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(30);
		obj.bst.insert(20);
		//obj.bst.root.getLeft().getLeft().getRight().setValue(30);
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