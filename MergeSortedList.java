// Time Complexity : O(n + m)
// Space Complexity : O(1)

class MergeSortedList {

	// list1.head will point to the merged list.

	public static void mergeList(LinkedList list1, LinkedList list2) {
		
		Node current1 = list1.head;
		Node prev1 = null;
		Node current2 = list2.head;

		if(list1.head == null || list2.head == null) {
			if(list2.head == null)
				return ;
			list1.head = list2.head;
		}

		if(current2.value < current1.value) {
			list1.head = current2;
			current2 = current2.next;
			prev1 = list1.head;
		}

		while(current1 != null && current2 != null) {
			if(current2.value < current1.value) {
				prev1.next = current2;
				prev1 = current2;
				current2 = current2.next;
				prev1.next = current1;
				continue;
			}
			prev1 = current1;
			current1 = current1.next;
		}

		if(current2 != null)
			prev1.next = current2;
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

		mergeList(list1, list2);
		list1.printList();
	}
}