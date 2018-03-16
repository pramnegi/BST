// Time Complexity : O(n + m)
// Space Complexity : O(1)

class MergeSortedList {

	// list1.head will point to the merged list.

	public static Node mergeList(Node node1, Node node2) {
		
		Node prev1 = null;
		Node temp = node1;

		if(node1 == null || node2 == null) {
			if(node2 == null)
				return node1;
			temp = node2;
		}

		if(node2.value < node1.value) {
			temp = node2;
			node2 = node2.next;
			prev1 = node1;
		}

		while(node1 != null && node2 != null) {
			if(node2.value < node1.value) {
				prev1.next = node2;
				prev1 = node2;
				node2 = node2.next;
				prev1.next = node1;
				continue;
			}
			prev1 = node1;
			node1 = node1.next;
		}

		if(node2 != null)
			prev1.next = node2;
		return temp;
	}
	
	public static void main(String[] argv) {

		LinkedList list1 = new LinkedList();
		list1.insertBeg(100);
		list1.insertBeg(70);
		list1.insertBeg(20);
		list1.insertBeg(10);
		list1.insertBeg(5);
		list1.insertBeg(-1);
		
		LinkedList list2 = new LinkedList();
		list2.insertBeg(40);
		list2.insertBeg(30);
		list2.insertBeg(25);
		list2.insertBeg(10);
		list2.insertBeg(5);

		Node newNode = mergeList(list1.head, list2.head);
		LinkedList.printList(newNode);
	}
}