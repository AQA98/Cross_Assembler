
public class Token {

	public class Node {
		private Mnemonics mnemonic;
		private Operand operand;
		private Label label;
		private Comment comment;
		private Directive directive;
		private Node next; // A link to the next node, which is of type Node1

		// Default constructors
		public Node() {
			next = null;
		}

		// Parameterized constructor
		public Node(Mnemonics mnemonic, Operand operand, Label label, Comment comment, Directive directive, Node next) {
			this.mnemonic = mnemonic;
			this.operand = operand;
			this.label = label;
			this.comment = comment;
			this.directive = directive;
			this.next = next;
		}

		public Mnemonics getMne() {
			return mnemonic;
		}

		public Label getLab() {
			return label;
		}

		public Operand getOp() {
			return operand;
		}

		public Comment getComment() {
			return comment;
		}

		public Directive getDir() {
			return directive;
		}

	} // end of inner class Node

	public static Node head;

	public Token() {
		head = null;
	}

	public static Node getHead() {
		return head;
	}

	// A method that adds an node to the start of the list
	public void addToStart(Mnemonics mnemonic, Operand operand, Label label, Comment comment, Directive directive) {
		head = new Node(mnemonic, operand, label, comment, directive, head); // This will result in "next" of this new
																				// node to
		// point to head

		// NOTE: A better way to achieve exactly what all the above three line are doing
		// would be as follows:
		// head = new Node(i, head);
	}

	public void addAtEnd(Mnemonics mnemonic, Operand operand, Label label, Comment comment, Directive directive) {
		if (head == null)
			head = new Node(mnemonic, operand, label, comment, directive, null);
		else {
			Node t = head;
			while (t.next != null)
				t = t.next;

			t.next = new Node(mnemonic, operand, label, comment, directive, null);
		}
		// NOTE: A better way to achieve exactly what the above three line are doing
		// would be as follows:
		// t.next = new Node(i, null);
	}

	public Node find(Mnemonics mnemonic, Operand operand, Label label, Comment comment, Directive directive) {
		if (head == null) // Can this special case verification be removed??
			return null; // Is it really needed? Why? Why not?
		Node t = head;
		while (t != null) {
			if (t.mnemonic.getMnemonic() == mnemonic.getMnemonic() && t.operand.getOperand() == operand.getOperand()
					&& t.label.getlabel() == label.getlabel() && t.comment.getComment() == comment.getComment()
					&& t.directive.getDirective() == directive.getDirective())
				return t; // Is that dangerous?? See Later

			t = t.next;
		}
		return null; // value was not found in the list
	}

	// A method to return the size of the list // is there a more efficient way to
	// find the size?
	public int size() {
		int ctr = 0;
		Node temp = head; // Point to the start of the list
		while (temp != null) {
			ctr++;
			temp = temp.next;
		}
		return ctr;
	}

	// A method that indicates whether or not a value is in the list
	public boolean contains(Mnemonics mnemonic, Operand operand, Label label, Comment comment, Directive directive) {
		if (find(mnemonic, operand, label, comment, directive) != null)
			return true;
		else
			return false;
	}

	// A method that searches the list for a node with value i1, and, if found, the
	// node is
	// modified to have value i2. If there is more than one node with value i1, the
	// first
	// node is the one to be modified

	public void showListContents() {
		Node temp = head;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty.");
		else
			System.out.println("\nHere are the contents of the list.");
		while (temp != null) {
			System.out.print("[ Mnemonic: " + temp.mnemonic.getMnemonic() + " Operand: " + temp.operand.getOperand()
					+ " Label: " + temp.label.getlabel() + " Comment: " + temp.comment.getComment() + " Directive: "
					+ temp.directive.getDirective() + " ]" + " ---> ");
			temp = temp.next; // Move to the next node
		}
		System.out.println("X"); // Just show "X" indicating the end of the list (null)
	}

	public Node singleNode(int index) {
		Node temp = head;
		int position = 0;
		if (index == 0) {
			return head;
		} else {
			while (position != index && temp != null) {
				temp = temp.next;
				position++;

			}
			return temp;
		}

	}

}

//public boolean replace(int i1, int i2)
//{
//	Node t = find(i1);
//	if(t == null)
//	{
//		System.out.println("\nCould not find value " + i1 + " in the list; no replacement is possible.");
//		return false;
//	}
//	t.v = i2;
//	return true;
//}

//public boolean insertAfter (int i, int x)
//{
//// insert a new node with value x after the first node with value i
//// if no node is found with value i, insertion will NOT take place and false is returned 
//if (head == null)
//{
//System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
//	return false;
//}
//	Node t = head;
//	while(t!= null && t.v != i)
//		t = t.next;
//	
//	if (t == null)
//	{
//		System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
//		return false;
//	}
//	
//	// if this point is reached then i is found; do the insertion
//	Node n = new Node(x, t.next);
//	t.next = n;
//	n = null;			// These 3 lines can be replaced by
//					// t.next = new Node(x, t.next);
//	return true;
//}
//
//
//public boolean insertBefore (int i, int x)
//{
//// insert a new node with value x before the first node with value i
//// if no node is found with value I, insertion will NOT take place and false is returned 
//if (head == null)
//{
//System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
//	return false;
//}
//
//	if(head.v == i)	// i is the first value at head
//	{
//		head = new Node(x, head);  
//		return true;
//	}
//
//	Node t = head;
//	while(t.next!= null && t.next.v != i)
//		t = t.next;
//	if (t.next == null)
//	{
//		System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
//		return false;
//	}
//	
//	// if this point is reached then i is found; do the insertion
//	Node n = new Node(x, t.next);
//	t.next = n;
//	n = null;			// These 3 lines can be replaced by
//					// t.next = new Node(x, t.next);
//	return true;
//}
