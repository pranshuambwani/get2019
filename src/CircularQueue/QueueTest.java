package CircularQueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

	@Test
	public void enqueueTest(){
		CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
		assertTrue(queue.enqueue(1));
		assertTrue(queue.enqueue(2));
		assertTrue(queue.enqueue(3));
		queue.dequeue();
		
	}
	
	@Test(expected= AssertionError.class)
	public void QueueFullTest(){
		CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
		queue.enqueue(1);
	}
	
	@Test
	public void DequeueTest(){
		CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals((Integer)1,(Integer) queue.dequeue());
		queue.enqueue(3);
		assertEquals((Integer)2,(Integer) queue.dequeue());
		queue.enqueue(4);
		assertEquals((Integer)3,(Integer) queue.dequeue());
		assertEquals((Integer)4,(Integer) queue.dequeue());
	}
	
	@Test(expected= AssertionError.class)
	public void DequeueEmptyTest(){
		CircularQueue<Integer> queue = new CircularQueue<Integer>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();		
		
	}
}
