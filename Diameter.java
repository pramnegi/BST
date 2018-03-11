class Diameter{

	private BST bst;

	Diameter(){
		this.bst = new BST();
	}

	private int height(BNode node, int height){
		if(node == null)
			return height;
		else{
			return Math.max( height(node.getLeft(), height + 1) , height(node.getRight(), height + 1));
		}
	}

	private int findDiameter(BNode node){
		if(node != null){
			int temp = 1 + height(node.getLeft(), -1) + height(node.getRight(), -1)	;
			int temp1 = Math.max(findDiameter(node.getLeft()), findDiameter(node.getRight())) ;
			return Math.max( temp, temp1);	
		}
		return -1;
	}

	public void findDiameter(){
		System.out.println(findDiameter(this.bst.root));
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
		new Diameter().findDiameter();				//check for empty binary search tree.
	}

}