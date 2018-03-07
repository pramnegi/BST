class BNode{

	BNode left, right;
	int value;

	BNode(int value){
		left = null;
		right = null;
		this.value = value;
	}

	void setLeftNode(BNode node){
		left = node;
	}

	void setRightNode(BNode node){
		right = node;
	}

	void setValue(int n){
		value = n;
	}

	int getValue(){
		return value;
	}

	BNode getLeft(){
		return left;
	}

	BNode getRight(){
		return right;
	}
}

public class BST{

	private BNode root;

	public BST(){
		root = null;
	}

	BNode insert(BNode node , int num){
		if(node == null){
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

	void insert(int num){
		root = insert(root, num);
	}

	int countNode(BNode node){
		if(node == null)
			return 0;
		else{
			return 1+countNode(node.getLeft()) + countNode(node.getRight());
		}
	}

	//Wrapper function to call countNode
	int countNode(){
		return countNode(root);
	}

	int sumValue(BNode node){
		if(node == null)
			return 0;
		else{
			return node.getValue() + sumValue(node.getLeft()) + sumValue(node.getRight());
		}
	}

	//Wrapper function to call sumValue

	int sumValue(){
		return sumValue(root);
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