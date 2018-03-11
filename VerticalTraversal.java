import java.util.*;

public class VerticalTraversal{

	private BST bst ; 

	public VerticalTraversal(){
		this.bst = new BST();
	}


	private void verticalTraversal(BNode node){
        
        if(node == null)
            return;

        int smallestKey = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();        
        Queue<BNode> nodeQueue = new LinkedList<BNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        
        nodeQueue.offer(node);
        levelQueue.offer(0);
        
        while(!nodeQueue.isEmpty()) {
            BNode top = nodeQueue.poll();
            Integer level = levelQueue.poll();
            if(map.get(level) == null)
            	map.put(level, new ArrayList<Integer>());
        	map.get(level).add(top.getValue());
            
            if(top.getLeft() != null) {
                nodeQueue.offer(top.getLeft());
                levelQueue.offer(level - 1);
                
                if(smallestKey > level-1)
                	smallestKey = level - 1;
            }
            
            if(top.getRight() != null) {
                nodeQueue.offer(top.getRight());
                levelQueue.offer(level + 1);
            }
        }
        while(map.containsKey(smallestKey)){
            System.out.println(map.get(smallestKey));
            smallestKey++;
         }
    }    
    
    public void verticalTraversal(){
        verticalTraversal(this.bst.root);
    }

	public static void main(String[] argv){
		VerticalTraversal obj = new VerticalTraversal();
		obj.bst.insert(70);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(20);
		obj.bst.insert(80);
		obj.bst.insert(10);
		obj.bst.insert(50);
		obj.bst.insert(40);
		obj.bst.insert(60);
		
		obj.verticalTraversal();
		new VerticalTraversal().verticalTraversal();				//check for empty binary search tree.
	}
}
