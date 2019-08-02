package Infix;

public class Stack<T> {

	Node<T> top;

	public Stack() {
		this.top = null;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	public T pop() {
		if (top == null) {
			throw new AssertionError("Stack is empty");
		}
		T data = (T) top.data;
		top = top.next;
		return data;
	}

	public T getTop() {
		return top.data;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	public class Node<T> {

		T data;
		Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

}