//Time Complexity : O(n)
//Space Complexity of recursive : O(n)
//Space Complexity of iterative : O(1)

class ReverseLinkedList {

	private LinkedList list;

	ReverseLinkedList() {
		this.list = new LinkedList();
	}

	private void iterativeReverseList(Node node) {
		Node current = node;
		Node prev = null;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}

	//Wrapper function to call reverseList.

	public void iterativeReverseList() {
		iterativeReverseList(this.list.head);
	}

	public void recursiveReverseList(Node node, Node prev){
		if(node == null){
			list.head = prev;
			return;
		}
		Node next = node.next;
		node.next = prev;
		recursiveReverseList(next, node);
	}

	public void recursiveReverseList() {
		recursiveReverseList(this.list.head, null);
	}

	public static void main(String[] argv) {
		ReverseLinkedList obj = new ReverseLinkedList();
		obj.list.insertBeg(40);
		obj.list.insertBeg(50);
		obj.list.insertBeg(20);
		obj.list.insertBeg(30);
		obj.list.insertBeg(10);
		obj.list.insertBeg(60);
		LinkedList.printList(obj.list.head);
		obj.iterativeReverseList();
		LinkedList.printList(obj.list.head);
		obj.recursiveReverseList();
		LinkedList.printList(obj.list.head);
	}
}