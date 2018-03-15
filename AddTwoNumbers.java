//Time Complexity : O(n)
//Space Complexity : O(n)

class AddTwoNumbers {

	public static int length(LinkedList list) {
		int length = 0;
		Node node = list.head;
		while(node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

	//Result will store in list1.
	public static int addNumber(Node node1, Node node2, int carry) {
		if(node1 == null && node2 == null)
			return 0;
		carry = addNumber(node1.next, node2.next, carry);
		int temp = carry + node1.value + node2.value;
		if(temp > 9){
			node1.value = temp%10;
			carry = 1;
		}
		else{
			node1.value = temp;
			carry = 0;	
		}
		return carry;
	}

	// Wrapper function to call addNumber

	public static void addNumber(LinkedList list1, LinkedList list2) {

		if(list1.head == null || list2.head == null) {
			if(list1.head == null)
				list1.head = list2.head;
			return;
		}
		
		int length1 = length(list1);
		int length2 = length(list2);
		int diff = Math.abs(length1 - length2);

		if(length1 < length2) {
			for(int i = 0; i < diff; i++)
				list1.insertBeg(0);
		}
		else {
			for(int i = 0; i < diff; i++)
				list2.insertBeg(0);
		}

		int carry = addNumber(list1.head, list2.head, 0);
		if(carry == 1)
			list1.insertBeg(1);
	}


	
	public static void main(String[] argv) {

		LinkedList list1 = new LinkedList();
		list1.insertBeg(9);
		list1.insertBeg(9);
		list1.insertBeg(9);
		list1.insertBeg(9);
		list1.insertBeg(9);
		
		LinkedList list2 = new LinkedList();
		list2.insertBeg(9);
		list2.insertBeg(9);
		list2.insertBeg(9);
		list2.insertBeg(9);
		list2.insertBeg(9);

		list1.printList();
		list2.printList();

		addNumber(list1, list2);
		list1.printList();
	}
}