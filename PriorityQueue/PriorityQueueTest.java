package PriorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void testAddTask() {
		PriorityQueue queue = new PriorityQueue(5);
		queue.addTask(1, 6);
		int expected = 6;
		assertEquals(expected, queue.removeTask());
	}

	@Test
	public void testAddTask2() {
		PriorityQueue queue = new PriorityQueue(5);
		queue.addTask(1, 7);
		queue.addTask(1, 8);
		int expected = 8;
		assertEquals(expected, queue.removeTask());
	}

	@Test
	public void testAddRemoveTask() {
		PriorityQueue queue = new PriorityQueue(5);
		queue.addTask(1, 6);
		queue.addTask(2, 4);
		queue.addTask(3, 7);
		int expected = 7;
		assertEquals(expected, queue.removeTask());
	}

	@Test(expected = AssertionError.class)
	public void testRemoveTaskWhenQueueIsEmpty() {
		PriorityQueue queue = new PriorityQueue(5);
		queue.removeTask();
	}

	@Test(expected = AssertionError.class)
	public void testAddTaskWhenQueueIsFull() {
		PriorityQueue queue = new PriorityQueue(2);
		queue.addTask(1, 6);
		queue.addTask(2, 5);
		queue.addTask(3, 7);
	}

	@Test
	public void testIsFull() {
		PriorityQueue queue = new PriorityQueue(2);
		queue.addTask(1, 6);
		queue.addTask(2, 5);
		assertEquals(true, queue.isFull());
	}

	@Test
	public void testIsNotFull() {
		PriorityQueue queue = new PriorityQueue(2);
		queue.addTask(1, 6);
		assertEquals(false, queue.isFull());
	}

	@Test
	public void testIsEmpty() {
		PriorityQueue queue = new PriorityQueue(5);
		assertEquals(true, queue.isEmpty());
	}

	@Test
	public void testIsNotEmpty() {
		PriorityQueue queue = new PriorityQueue(2);
		queue.addTask(1, 6);
		assertEquals(false, queue.isEmpty());
	}
}