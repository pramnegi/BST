import java.util.*;
public class ChangeValue{

	BST bst ; 
	int count;

	ChangeValue(){
		bst = new BST();
		count = 1;
	}

	int sumValue(BNode node){
		System.out.println(count++);
		if(node == null)
			return 0;
		else{
			int value = node.getValue();
			int temp = sumValue(node.getLeft()) + sumValue(node.getRight());
			node.setValue(temp);
			value += temp;
			return value;
		}
		
	}

	public void sumValue(){
		sumValue(bst.root);
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