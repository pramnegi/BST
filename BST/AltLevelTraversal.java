import java.util.Stack;

public class AltLevelTraversal {

	private BST bst ; 

	public AltLevelTraversal() {
		this.bst = new BST();
	}

	private void altLevel(Stack<BNode> stack1, Stack<BNode> stack2) {
		if(this.bst.root == null) {
			return;
		}

		stack1.push(this.bst.root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(!stack1.isEmpty()) {
				while(!stack1.isEmpty()) {
					BNode top = stack1.pop();
					System.out.print(top.getValue() + " ");
					if(top.getLeft() != null){
						stack2.push(top.getLeft());
					}
					if(top.getRight() != null){
						stack2.push(top.getRight());
					}
				}
			} else {
				while(!stack2.isEmpty()) {
					BNode top = stack2.pop();
					System.out.print(top.getValue() + " ");
					if(top.getRight() != null){
						stack1.push(top.getRight());
					}
					if(top.getLeft() != null){
						stack1.push(top.getLeft());
					}
				}
			}
			System.out.println();
		}
	} 

	//Wrapper function to call findEachLevelSum function.
	public void altLevel() {
		Stack<BNode> stack1 = new Stack<BNode>();
		Stack<BNode> stack2 = new Stack<BNode>();
		altLevel(stack1, stack2);
	}

	public static void main(String[] argv) {
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
