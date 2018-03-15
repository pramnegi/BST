// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.Stack;

class IsListPalindrome {
	
	public static int length(LinkedList list) {
		int length = 0;
		Node node = list.head;
		while(node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

	private static boolean isPalindrome(Node node,  int length) {
		Stack<Node> stack = new Stack<>();
		int count = 1;
		while(count <= length/2) {
			stack.push(node);
			node = node.next;
			count++;
		}
		if(length % 2 != 0)
			node = node.next;
		
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			if(temp.value != node.value)
				return false;
			node = node.next;
		}
		return true;
	}

	public static void isPalindrome(LinkedList list1) {
		int length = length(list1);
		if(length < 2) {
			System.out.println("Palindrome");
			return;
		}
		if(isPalindrome(list1.head, length))
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");
	}

	public static void main(String[] argv) {

		LinkedList list1 = new LinkedList();
		list1.insertBeg(6);
		list1.insertBeg(5);
		list1.insertBeg(4);
		list1.insertBeg(0);
		list1.insertBeg(4);
		list1.insertBeg(9);
		list1.insertBeg(6);

		list1.printList();

		isPalindrome(list1);
	}
}