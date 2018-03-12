import java.util.*;

public class LevelSum{

	private BST bst ; 

	public LevelSum(){
		this.bst = new BST();
	}

	private void findEachLevelSum(BNode node, int level, Map<Integer,Integer> map) {
		if(node != null) {
			if(map.containsKey(level))
				map.put(level, map.get(level) + node.getValue());
			else
				map.put(level, node.getValue());
			findEachLevelSum(node.getLeft(), level + 1, map);
			findEachLevelSum(node.getRight(), level + 1, map);
		}
	} 

	//Wrapper function to call findEachLevelSum function.
	public void findEachLevelSum() {
		Map<Integer, Integer> map = new HashMap<>();
		findEachLevelSum(this.bst.root, 0, map);
		if(map.size() == 0)
			System.out.println("Tree is empty");
		for(Map.Entry entry : map.entrySet()){
			System.out.println("Level " + entry.getKey() + " sum : " + entry.getValue());
		}
	}

	public static void main(String[] argv) {
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
		new LevelSum().findEachLevelSum();				//check for empty binary search tree.
	}
}
