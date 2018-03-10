import java.util.*;

public class AltLevelTraversal{

	private BST bst ; 

	public AltLevelTraversal(){
		this.bst = new BST();
	}

	private void altLevel(Stack<BNode> stack1, Stack<BNode> stack2){
		
		if(this.bst.root == null) {
			return;
		}
		System.out.println(this.bst.root.getValue() + " ");
		stack1.push(this.bst.root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			
			while(!stack1.isEmpty()) {
				BNode currentNode = stack1.pop();
				if(currentNode.getRight() != null){
					System.out.print(currentNode.getRight().getValue() + " ");
					stack2.push(currentNode.getRight());
				}
				if(currentNode.getLeft() != null){
					System.out.print(currentNode.getLeft().getValue() + " ");
					stack2.push(currentNode.getLeft());
				}
			}
			System.out.println();
				
			while(!stack2.isEmpty()) {
				BNode currentNode = stack2.pop();
				if(currentNode.getLeft() != null){
					System.out.print(currentNode.getLeft().getValue() + " ");
					stack1.push(currentNode.getLeft());
				}
				if(currentNode.getRight() != null){
					System.out.print(currentNode.getRight().getValue() + " ");
					stack1.push(currentNode.getRight());
				}
			}
			System.out.println();
		}

	} 

	//Wrapper function to call findEachLevelSum function.
	public void altLevel(){
		boolean isEvenLevel = true;
		Stack<BNode> stack1 = new Stack<BNode>();
		
		Stack<BNode> stack2 = new Stack<BNode>();
		altLevel(stack1, stack2);
	}

	public static void main(String[] argv){
		AltLevelTraversal obj = new AltLevelTraversal();
		obj.bst.insert(70);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(20);
		obj.bst.insert(80);
		obj.bst.insert(10);
		obj.bst.insert(50);
		obj.bst.insert(40);
		obj.bst.insert(60);
		obj.bst.insert(5);
		obj.bst.insert(15);
		obj.bst.insert(45);
		obj.bst.insert(65);
		obj.bst.insert(55);
		obj.bst.insert(35);
		
		obj.altLevel();
		new AltLevelTraversal().altLevel();				//check for empty binary search tree.
	}
}
