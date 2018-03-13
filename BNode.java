public class BNode {

	private BNode left, right;
	private int value;

	BNode(int value) {
		this.left = null;
		this.right = null;
		this.value = value;
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

