class Node {
	int value;
	Node next;
	Node(int value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {
	
	Node head;

	LinkedList() {
		this.head = null;
	}

	public void insertBeg(int num) {

		Node node = new Node(num);

		if(this.head != null)
			node.next = head;

		head = node;
	}

	public void printList() {

		Node currentNode = head;

		while(currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.next ;
		}

		System.out.println();
	}

	public static void main(String[] argv) {
		LinkedList l = new LinkedList();
		l.insertBeg(40);
		l.insertBeg(50);
		l.insertBeg(20);
		l.insertBeg(30);
		l.insertBeg(10);
		l.insertBeg(60);
		l.printList();
	}
}