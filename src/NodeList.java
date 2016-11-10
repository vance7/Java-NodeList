
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

	// get Node data
	public static int getData(Node current) {
		return current.data;
	}

	// get NodeList length
	public static int getLength(Node head) {
		if (head == null)
			return 0;
		int length = 1;
		Node current = head;
		while (current.next != null) {
			current = current.next;
			length++;
		}
		return length;
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

	// print NodeList reversely
	public static void reversePrintList(Node head) {
		if (head == null)
			return;
		reversePrintList(head.next);
		System.out.println(head.data);
	}

	// get the Kth node from end
	public static Node getKthNodeFromEnd(Node head, int k) {
		if (k > getLength(head))
			return null;
		Node slowNode = head;
		Node fastNode = head;
		for (int i = 0; i < k; i++) {
			fastNode = fastNode.next;
		}
		while (fastNode != null) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}

	// get the middle node of the list(DO NOT use getLength method)
	public static Node getMiddleNode(Node head) {
		if (head == null || head.next == null)
			return head;
		Node slowNode = head;
		Node fastNode = head;
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return slowNode;
	}

	// merge two sorted NodeList
	public static Node mergeList(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;
		else {
			Node resultNode = new Node();
			Node current = resultNode;
			while (head1 != null & head2 != null) {
				if (head1.data >= head2.data) {
					current.next = head2;
					head2 = head2.next;
					current = current.next;
				} else {
					current.next = head1;
					head1 = head1.next;
					current = current.next;
				}
			}
			if (head1 == null)
				current.next = head2;
			if (head2 == null)
				current.next = head1;
			return resultNode.next;
		}
	}

	// judge if the NodeList has a circle
	public static boolean hasCircle(Node head) {
		Node slowNode = head;
		Node fastNode = head;
		while (slowNode != null && fastNode != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if (slowNode == fastNode)
				return true;
		}
		return false;
	}

	// find the first crossed node of the two NodeList
	public static Node getCrossedNode(Node head1, Node head2) {
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		if (length1 > length2) {
			int k = length1 - length2;
			Node fastNode = head1;
			Node slowNode = head2;
			for (int i = 0; i < k; i++)
				fastNode = fastNode.next;
			while (fastNode != slowNode) {
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
			return fastNode;
		} else {
			int k = length2 - length1;
			Node fastNode = head2;
			Node slowNode = head1;
			for (int i = 0; i < k; i++)
				fastNode = fastNode.next;
			while (fastNode != slowNode) {
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
			return fastNode;
		}
	}

	// main
	public static void main(String[] args) {
		int[] array1 = { 1, 3, 5, 7, 9, 11 };

	}
}
