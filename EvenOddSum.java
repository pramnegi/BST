public class EvenOddSum{

	int evenLevelSum ; 
	int oddLevelSum ;
	BST bst ; 

	EvenOddSum(){
		bst = new BST();
		evenLevelSum = 0;
		oddLevelSum = 0;
	}

	public void findLevelSum(BNode node, int level){
		if(node == null){	
			return;
		}
		else if(level % 2 == 0){
			evenLevelSum += node.getValue();
		}
		else{
			oddLevelSum += node.getValue();
		}
		level++ ;
		findLevelSum(node.getLeft() , level);
		findLevelSum(node.getRight() , level);
		return ;
	} 

	//Wrapper function to call findLevelSum function.

	public void findLevelSum(){
		//assigning value 0 otherwise if we call finlevel function more than once it'll chance the value.
		evenLevelSum = 0;
		oddLevelSum = 0;
		findLevelSum(bst.root , 0);
		System.out.println("Even level sum = " + evenLevelSum);
		System.out.println("Odd level sum = " + oddLevelSum);
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