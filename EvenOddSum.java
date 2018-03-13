public class EvenOddSum{

	private BST bst ; 
	EvenOddSum(){
		bst = new BST();
	}

	public void findLevelSum(BNode node, int level, int[] sum){
		if(node == null){	
			return;
		}
		
		sum[level % 2] += node.getValue();
		
		findLevelSum(node.getLeft(), level + 1 , sum);
		findLevelSum(node.getRight(), level + 1, sum);
	} 

	//Wrapper function to call findLevelSum function.
	public void findLevelSum() {
		//assigning value 0 otherwise if we call findlevel function more than once it'll change the value.
		int[] sum = new int[]{0,0};
		findLevelSum(bst.root, 0, sum);
		System.out.println("Even level sum = " + sum[0]);
		System.out.println("Odd level sum = " + sum[1]);
	}

	public static void main(String[] argv){
		EvenOddSum obj = new EvenOddSum();
		obj.bst.insert(7);
		obj.bst.insert(9);
		obj.bst.insert(3);
		obj.bst.insert(2);
		obj.bst.insert(8);
		obj.bst.insert(1);
		obj.bst.insert(5);
		obj.bst.insert(4);
		obj.bst.insert(6);
		
		obj.findLevelSum();
		new EvenOddSum().findLevelSum();				//check for empty binary search tree.
	}
}
