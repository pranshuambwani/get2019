package PriorityQueue;

public interface PriorityQueueInterface {

	public void addTask(int job, int priority);

	public int removeTask();

	public boolean isFull();

	public boolean isEmpty();
}