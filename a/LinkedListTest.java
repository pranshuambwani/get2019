package DSAssignment1;

import static org.junit.Assert.*;

import org.junit.Test;

import DSAssignment1.LinkedList.Node;

public class LinkedListTest {

	@Test
	public void LoopTest() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		Node traverse = list.start;
		while (traverse.next != null)
			traverse = traverse.next;
		traverse.next = list.start;
		assertTrue(list.DetectLoop());
	}

	@Test
	public void NegativeLoopTest() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		assertFalse(list.DetectLoop());
	}

	@Test
	public void LinkedTest() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		LinkedList result = new LinkedList(new Integer[] { 2, 5, 6, 3, 4, 7 });
		list.RotateSubList(2, 5, 2);
		Node traverse = list.start;
		Node answer = result.start;
		while (traverse != null && answer != null) {
			assertEquals(traverse.data, answer.data);
			traverse = traverse.next;
			answer = answer.next;
		}

	}

	@Test
	public void NegativeLinkedTest() {
		LinkedList list = new LinkedList(new Integer[] { 2, 3, 4, 5, 6, 7 });
		LinkedList result = new LinkedList(new Integer[] { 2, 5, 7, 3, 4, 6 });
		list.RotateSubList(1, 5, 1);
		Node traverse = list.start;
		Node answer = result.start;
		while (traverse != null && answer != null) {
			assertNotEquals(traverse.data, answer.data);
			traverse = traverse.next;
			answer = answer.next;
		}

	}

}
