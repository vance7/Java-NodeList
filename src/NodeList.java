
public class NodeList {
	// Node class
	private static class Node {
		int data;
		Node next;

		Node() {
			this.data = -1;
			this.next = null;
		}

		Node(int item) {
			this.data = item;
			this.next = null;
		}
	}

	// build NodeList
	public static Node buildList(int[] array) {
		Node head = new Node();
		Node current = head;
		if (array == null)
			return head;
		for (int i = 0; i < array.length; i++) {
			current.next = new Node(array[i]);
			current = current.next;
		}
		return head.next;
	}

	// reverse NodeList
	public static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;
		Node currentNode = head;
		Node prevNode = null;
		Node resultNode = null;
		while (currentNode != null) {
			Node nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			resultNode = currentNode;
			currentNode = nextNode;
		}
		return resultNode;
	}

	// print NodeList
	public static void printList(Node head) {
		if (head == null)
			System.out.println("");
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	// reverse print NodeList
	public static void reversePrintList(Node head) {
		if (head == null)
			return;
		reversePrintList(head.next);
		System.out.println(head.data);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		Node head = buildList(array);
		// printList(head);
		// Node fakeHead = reverseList(head);
		// printList(fakeHead);
		reversePrintList(head);
		printList(head);
	}

}
