//Time Complexity : O(n)
//Space Complexity : O(1)

class RemoveAllK {

	private LinkedList list;

	RemoveAllK() {
		this.list = new LinkedList();
	}

	private void removeK(int k) {
		if(this.list.head == null)
			return;
		Node prev = null;
		Node current = this.list.head;
		while(current != null){
			if(current.value == k){
				if(prev == null)
					this.list.head = current.next;
				else
					prev.next = current.next;
				current = current.next;
				continue;
			}
			prev = current;
			current = current.next; 
		}
	}

	public static void main(String[] argv) {
		RemoveAllK obj = new RemoveAllK();
		obj.list.insertBeg(40);
		obj.list.insertBeg(50);
		obj.list.insertBeg(20);
		obj.list.insertBeg(30);
		obj.list.insertBeg(10);
		obj.list.insertBeg(60);
		obj.list.insertBeg(20);
		LinkedList.printList(list.head);
		obj.removeK(200);
		LinkedList.printList(list.head);
	}
}