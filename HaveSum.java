import java.util.Queue;
class HaveSum{

	private BST bst;

	HaveSum(){
		bst = new BST();
	}

	private boolean checkSum(BNode node, int sum, int currentSum){

		if(node != null){
			currentSum = currentSum + node.getValue();
			if(sum == currentSum && node.getLeft() == null && node.getRight() == null)
				return true;
			return checkSum(node.getLeft() , sum , currentSum) || checkSum(node.getRight() , sum , currentSum);
		}
		return false;
	}

	public void checkSum(int sum){
		if (checkSum(this.bst.root , sum, 0)) 
			System.out.println("Sum exist!");
		else
			System.out.println("Sum not exist!");
	}

	public static void main(String[] argv){
		HaveSum obj = new HaveSum();
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
		new HaveSum().checkSum(0);				//check for empty binary search tree.
	}	
}