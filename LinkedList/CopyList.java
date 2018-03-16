class RNode {
	int value;
	RNode next;
	RNode random;

	RNode(int value) {
		this.value = value;
		this.next = null;
		this.random = null;
	}
}

class RandomLinkedList {
	
	RNode head;

	RandomLinkedList() {
		this.head = null;
	}

	public void insertBeg(int num) {

		RNode node = new RNode(num);

		if(this.head != null)
			node.next = head;

		head = node;
	}

	public void printList(RNode node) {

		while(node != null) {
			System.out.print(node.value + " ");
			node = node.next ;
		}
		System.out.println();
	}
}


class CopyList {

	public static RNode makeCopy(RNode node) {
		
		if(node == null)
			return null;

		RNode current = node;

		//Inserting node between two nodes.

		while(current != null) {
			RNode newNode = new RNode(current.value);
			newNode.next = current.next;
			current.next = newNode;
			current = newNode.next;	
		}

		//Adjusting random Node.
		current = node;

		while(current != null) {
			if(current.random != null)
				current.next.random = current.random.next;
			current = current.next.next;
		}
		
		//Seperating both the LinkedList.

		RNode newListHead = node.next;

		while(node.next.next != null) {
			RNode temp = node.next;
			node.next = temp.next;
			temp.next = node.next.next;
			node = node.next;
		}
		node.next.next = null;
		node.next = null;

		return newListHead;
	}

	public static void main(String[] argv) {
		RandomLinkedList l = new RandomLinkedList();
		l.insertBeg(10);
		l.insertBeg(20);
		l.insertBeg(30);
		l.insertBeg(40);
		l.insertBeg(50);
		l.insertBeg(60);
		l.head.random = l.head.next.next.next;
		l.head.next.next.next.random = l.head;
		l.printList(l.head);
		RNode newList = makeCopy(l.head);
		l.printList(newList);
	}
}