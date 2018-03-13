import java.util.Map;
import java.util.HashMap;
class Diameter {

	private BST bst;

	Diameter(){
		this.bst = new BST();
	}

	private int height(BNode node, Map<BNode, Integer> map) {
		if(node == null)
			return 0;
		else if(map.get(node) == null)
			map.put(node, 1 + Math.max(height(node.getLeft(), map), height(node.getRight(), map)));
		return map.get(node);
	}

	private int findDiameter(BNode node, Map<BNode, Integer> map) {
		int leftMax = 0, rightMax = 0;
		if(node != null) {
			if(node.getLeft() != null)
				leftMax = map.get(node.getLeft());
			if(node.getRight() != null)
				rightMax = map.get(node.getRight());
			int temp1 = 1 + Math.max(leftMax, rightMax);
			int temp2 = Math.max(findDiameter(node.getLeft(), map), findDiameter(node.getRight(), map)) ;
			return Math.max( temp1, temp2);	
		}
		return -1;
	}

	public void findDiameter() {
		Map<BNode, Integer> map = new HashMap<>();
		height(this.bst.root, map);
		System.out.println(findDiameter(this.bst.root, map));
	}

	public static void main(String[] argv) {
		Diameter obj = new Diameter();
		obj.bst.insert(70);
		obj.bst.insert(90);
		obj.bst.insert(30);
		obj.bst.insert(30);
		obj.bst.insert(20);
		obj.bst.insert(80);
		obj.bst.insert(10);
		obj.bst.insert(50);
		obj.bst.insert(40);
		obj.bst.insert(60);
		obj.bst.insert(66);
		obj.bst.insert(67);
		
		obj.findDiameter();
		new Diameter().findDiameter();			//check for empty binary search tree.
	}

}
