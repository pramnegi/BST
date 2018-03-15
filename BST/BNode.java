public class BNode {

	BNode left, right;
	int value;

	BNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	void setLeftNode(BNode node) {
		this.left = node;
	}

	void setRightNode(BNode node) {
		this.right = node;
	}

	void setValue(int value) {
		this.value = value;
	}

	int getValue() {
		return this.value;
	}

	BNode getLeft() {
		return this.left;
	}

	BNode getRight() {
		return this.right;
	}
}

