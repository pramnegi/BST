public class BNode{

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