import java.util.Map;
import java.util.HashMap;
class Diameter{

	private BST bst;

	Diameter(){
		this.bst = new BST();
	}

	private int findDiameter(BNode node, int[] diameter){
    	if(node == null)
        	return 0; 
    	int l = findDiameter(node.getLeft(), diameter);
    	int r = findDiameter(node.getRight(), diameter);
    	if(diameter[0] < 1 + l + r)
        	diameter[0] = 1 + l + r;
    	return 1 + Math.max(l, r);
	}
    
    public void findDiameter() {
    	int[] diameter = new int[]{0};
    	findDiameter(this.bst.root, diameter);
    	System.out.println(diameter[0]);
	}

	public static void main(String[] argv){
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