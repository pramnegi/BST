import java.util.*;
public class ChangeValue{


	private BST bst ; 

	ChangeValue(){
		this.bst = new BST();
	}

	int sumValue(BNode node){
		if(node == null) {
			return 0;
		}
		
		int nodeValue = node.getValue();		
		node.setValue(sumValue(node.getLeft()) + sumValue(node.getRight()));
		return nodeValue + node.getValue();
	}

	public void sumValue(){
		sumValue(this.bst.root);
	}

	public void printTreePreOrder(BNode node){
		if(node == null)
			return;
		System.out.print(node.getValue()+" ");
		printTreePreOrder(node.getLeft());
		printTreePreOrder(node.getRight());

	}

	//Wrapper function to call printTreePreOrder function.
	public void printTreePreOrder(){
		printTreePreOrder(bst.root);
		System.out.println();
	}
	
	public static void main(String[] argv){
		ChangeValue obj = new ChangeValue();
		obj.bst.insert(7);
		obj.bst.insert(9);
		obj.bst.insert(3);
		obj.bst.insert(2);
		obj.bst.insert(8);
		obj.bst.insert(1);
		obj.bst.insert(5);
		obj.bst.insert(4);
		obj.bst.insert(16);
		obj.bst.insert(26);
		obj.bst.insert(56);
		
		System.out.print("initial BST : ");
		obj.printTreePreOrder();
		obj.sumValue();
		System.out.print("tree after changing node values : ");
		obj.printTreePreOrder();
		new ChangeValue().sumValue();				//check for empty binary search tree.
	}

}
