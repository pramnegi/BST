import java.util.*;
class IterativeTraversal{
	
	private BST bst;

	IterativeTraversal(){
		this.bst = new BST();
	}

	public void preOrderTraversal(){
		ArrayList<BNode> al = new ArrayList<>();
		if(this.bst.root != null)
			al.add(this.bst.root);
		while(al.size() != 0){
			BNode currentNode = al.remove(al.size()-1);			//To get the last element from end of the ArrayList.
			System.out.print(currentNode.getValue() + " ");
			if(currentNode.getRight() != null)
				al.add(currentNode.getRight());
			if(currentNode.getLeft() != null)
				al.add(currentNode.getLeft());
		}
		System.out.println();
	}

	public void inOrderTraversal(){
		ArrayList<BNode> al = new ArrayList<>();
		BNode currentNode = bst.root;			
		boolean flag = true;
		while(flag){
			if(currentNode != null){
				al.add(currentNode);
				currentNode = currentNode.getLeft();
			}
			else{
				if(al.size() == 0)
					break;
				currentNode = al.remove(al.size() - 1);
				System.out.print(currentNode.getValue() + " ");
				currentNode = currentNode.getRight();
			}
			
		}

		// do{
		// 	if(currentNode != null){
		// 		al.add(currentNode);
		// 		currentNode = currentNode.getLeft();
		// 	}
		// 	else{
		// 		if(al.size() == 0)
		// 			break;
		// 		currentNode = al.remove(al.size() - 1);
		// 		System.out.print(currentNode.getValue() + " ");
		// 		currentNode = currentNode.getRight();
		// 	}
			
		// }while(al.size() != 0);
		System.out.println();
	}

	public void levelTraversal(){
		ArrayList<BNode> al = new ArrayList<>();
		if(this.bst.root != null)
			al.add(this.bst.root);
		while(al.size() != 0){
			BNode currentNode = al.remove(0);			//To get the last element from strting the ArrayList.
			System.out.print(currentNode.getValue() + " ");
			if(currentNode.getLeft() != null)
				al.add(currentNode.getLeft());
			if(currentNode.getRight() != null)
				al.add(currentNode.getRight());
		}
		System.out.println();
	}

	public static void main(String[] argv){

		IterativeTraversal obj = new IterativeTraversal();
		obj.bst.insert(40);
		obj.bst.insert(10);
		obj.bst.insert(70);
		obj.bst.insert(50);
		obj.bst.insert(20);
		obj.bst.insert(30);
		obj.bst.insert(80);
		System.out.print("PreOrder Traversal : ");
		obj.preOrderTraversal();
		System.out.print("inOrder Traversal : ");
		obj.inOrderTraversal();
		System.out.print("LevelOrder Traversal : ");
		obj.levelTraversal();
		//new IterativeTraversal().preOrderTraversal();				//check for empty binary search tree.
	}

}
