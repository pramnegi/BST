import java.util.*;

public class AltLevelTraversal{

	private BST bst ; 

	public AltLevelTraversal(){
		this.bst = new BST();
	}

	private void altLevel(boolean isEvenLevel, Queue<BNode> evenQueue, ArrayList<BNode> oddAl){
		if(evenQueue.peek() == null) {
			return;
		}
		while(!evenQueue.isEmpty() || !oddAl.isEmpty()){
			if(isEvenLevel){
				while(!evenQueue.isEmpty()) {
					BNode currentNode = evenQueue.poll();
					System.out.print(currentNode.getValue() + " ");
					if(currentNode.getLeft() != null)
						oddAl.add(currentNode.getLeft());
					if(currentNode.getRight() != null)
						oddAl.add(currentNode.getRight());	
				}
				isEvenLevel = false;
			}
			else{
				int index = 0 , size = oddAl.size();
				while(size > 0) {
					System.out.print(oddAl.get(size - 1).getValue() + " ");
					if(oddAl.get(index).getLeft() != null){
						evenQueue.offer(oddAl.get(index).getLeft());
					}
					if(oddAl.get(index).getRight() != null){
						evenQueue.offer(oddAl.get(index).getRight());
					}
					index++;
					size--;
				}
				oddAl.clear();
				isEvenLevel = true;
			}
			System.out.println();
		}

	} 

	//Wrapper function to call findEachLevelSum function.
	public void altLevel(){
		boolean isEvenLevel = true;
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.offer(this.bst.root);
		ArrayList<BNode> al = new ArrayList<BNode>();
		altLevel(isEvenLevel, queue, al);
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
