import java.util.Queue;
class HasSum {

	private BST bst;

	HasSum() {
		this.bst = new BST();
	}

	private boolean checkSum(BNode node, int sum) {
		if(node == null)
			return false;

		if((sum == node.value) && node.getLeft() == null && node.getRight() == null) {
			return true;
		}

		return checkSum(node.getLeft(), sum - node.value) || checkSum(node.getRight(), sum - node.value);
	}

	public void checkSum(int sum) {
		if (checkSum(this.bst.root, sum)) 
			System.out.println("Sum exist!");
		else
			System.out.println("Sum not exist!");
	}

	public static void main(String[] argv) {
		HasSum obj = new HasSum();
		obj.bst.insert(70);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(20);
		obj.bst.insert(80);
		obj.bst.insert(-40);
		obj.bst.insert(50);
		obj.bst.insert(40);
		obj.bst.insert(85);
		
		obj.checkSum(190);
		new HasSum().checkSum(0);				//check for empty binary search tree.
	}	
}
