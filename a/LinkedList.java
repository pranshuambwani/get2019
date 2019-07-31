package DSAssignment1;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	Node start = null;

	/**
	 * name: linkedList
	 * 
	 * @param list
	 */
	public LinkedList(Integer[] list) {
		for (int loop = 0; loop <= list.length - 1; loop++) {
			AddElement(list[loop]);
		}
	}

	/**
	 * name: AddElement -to add the element in list
	 * 
	 * @param data
	 * @return boolean
	 * @throws AssertionError
	 */
	public boolean AddElement(Integer data) throws AssertionError {
		if (data == null) {
			throw new AssertionError("element is null");
		}
		Node node = new Node(data);
		if (start == null) {
			start = node;
			return true;
		} else {
			Node lastnode = start;
			while (lastnode.next != null) {
				lastnode = lastnode.next;
			}
			lastnode.next = node;
		}
		return true;
	}

	/**
	 * name: countElements- to count the number of elements in list
	 * 
	 * @param start
	 * @return count-Integer
	 */
	public Integer countElements(Node start) {
		Node traverse = start;
		Integer count = 0;
		while (traverse != null) {
			count++;
			traverse = traverse.next;
		}
		return count;
	}

	/**
	 * name: Rotate-SubList get the elements of right and left.
	 * 
	 * @param left
	 * @param right
	 * @param rotation
	 * @throws AssertionError
	 */
	public void RotateSubList(Integer left, Integer right, Integer rotation)
			throws AssertionError {
		int totalElements = countElements(start);
		if (left < 1 || right > totalElements) {
			throw new AssertionError("left and right are Out of range");
		}
		int count = 1;
		Node traverse = start;
		Node leftNode = null;
		Node rightNode = null;
		while (traverse != null) {
			if (count == left) {
				leftNode = traverse;
			}
			if (count == right) {
				rightNode = traverse;
			}
			count++;
			traverse = traverse.next;
		}

		Rotate(leftNode, rightNode, rotation);
	}

	/**
	 * name: Rotate -shift the position of elements in list
	 * 
	 * @param left
	 * @param right
	 * @param rotation
	 */
	public void Rotate(Node left, Node right, Integer rotation) {
		while (rotation > 0) {
			Node traverse = left;
			int temp = traverse.data;
			Node nextNode = null;
			while (traverse != right) {
				nextNode = traverse.next;
				Integer temp2 = nextNode.data;
				nextNode.data = temp;
				temp = temp2;
				traverse = traverse.next;
			}
			left.data = temp;
			rotation--;
		}
	}

	/**
	 * name: DetectLoop- to detect the loop in the list
	 * 
	 * @return boolean
	 */
	public Boolean DetectLoop() {
		List<Node> list = new ArrayList<Node>();
		Node traverse = start;
		while (traverse != null) {
			if (list.contains(traverse))
				return true;
			list.add(traverse);
			traverse = traverse.next;
		}
		return false;
	}

	/**
	 * name: Node
	 * 
	 * @author Pranshu
	 *
	 */
	public class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}
}
