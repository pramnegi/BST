import java.util.*;

public class LevelSum{

	int levelSum ; 
	BST bst ; 

	LevelSum(){
		bst = new BST();
		levelSum = 0;
	}

	public void findEachLevelSum(ArrayList<BNode> a1, ArrayList<BNode> a2 , boolean flag, int level){
		/*
			two ArrayLists, one to insert value of all node of a given level and another for the child nodes or nodes of the next level. 
			flag = true implies level nodes in a1 and child nodes in a2 and vica versa.
		*/

		if(a1.isEmpty() && a2.isEmpty())	
			return;
		else if(flag){
			for(int i = a1.size()-1; i >= 0 ; i--){
				//BNode temp = a1.get(i);
				BNode temp = a1.remove(i);
				levelSum += temp.getValue();
				if(temp.getLeft() != null)
					a2.add(temp.getLeft());
				if(temp.getRight() != null)
					a2.add(temp.getRight());
			}
			flag = false;
			System.out.println("Level "+level+" sum : "+levelSum);
			level++;
			levelSum = 0;
		}
		else if(!flag){
			for(int i = a2.size()-1; i >= 0 ; i--){
				//BNode temp = a2.get(i);
				BNode temp = a2.remove(i);
				levelSum += temp.getValue();
				if(temp.getLeft() != null)
					a1.add(temp.getLeft());
				if(temp.getRight() != null)
					a1.add(temp.getRight());
			}
			flag = true;
			System.out.println("Level "+level+" sum : "+levelSum);
			level++;
			levelSum = 0;
		}

		findEachLevelSum(a1,a2, flag, level);
			
	} 

	//Wrapper function to call findEachLevelSum function.

	public void findEachLevelSum(){
		boolean flag = true ;   // flag true implies level nodes in a1 and child nodes in a2 and vica versa.
		ArrayList<BNode> a1 = new ArrayList<>();
		ArrayList<BNode> a2 = new ArrayList<>();
		if(bst.root != null)
			a1.add(bst.root);
		else
			System.out.println("Empty binary search tree");
		findEachLevelSum(a1, a2, flag, 0);
	}

	public static void main(String[] argv){
		LevelSum obj = new LevelSum();
		obj.bst.insert(7);
		obj.bst.insert(9);
		obj.bst.insert(3);
		obj.bst.insert(2);
		obj.bst.insert(8);
		obj.bst.insert(1);
		obj.bst.insert(5);
		obj.bst.insert(4);
		obj.bst.insert(6);
		
		obj.findEachLevelSum();
		//new LevelSum().findEachLevelSum();				//check for empty binary search tree.
	}

}