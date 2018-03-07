class BNode{

	private BNode left, right;
	private int value;

	BNode(int value){
		this.left = null;
		this.right = null;
		this.value = value;
	}

	void setLeftNode(BNode node){
		this.left = node;
	}

	void setRightNode(BNode node){
		this.right = node;
	}

	void setValue(int value){
		this.value = value;
	}

	int getValue(){
		return this.value;
	}

	BNode getLeft(){
		return this.left;
	}

	BNode getRight(){
		return this.right;
	}
}

public class BST{

	private BNode root;

	public BST(){
		this.root = null;
	}

	private BNode insert(BNode node, int num){
		if(node == null) {
			node = new BNode(num);
		}
		else{
			if (num < node.getValue())
				node.left = insert(node.getLeft() , num);
			else
				node.right = insert(node.getRight() , num);
		}
		return node;
	}

	//Wrapper function to call insert.
	public void insert(int num){
		this.root = insert(this.root, num);
	}

	private int countNode(BNode node){
		if(node == null)
			return 0;
		else{
			return 1 + countNode(node.getLeft()) + countNode(node.getRight());
		}
	}

	//Wrapper function to call countNode
	public int countNode(){
		return countNode(this.root);
	}

	private int sumValue(BNode node){
		if(node == null)
			return 0;
		else{
			return node.getValue() + sumValue(node.getLeft()) + sumValue(node.getRight());
		}
	}

	//Wrapper function to call sumValue

	public int sumValue(){
		return sumValue(this.root);
	}

	public static void main(String[] argv){
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
		//System.out.println(bst.countNode());
		System.out.println(bst.sumValue());
	}

}
