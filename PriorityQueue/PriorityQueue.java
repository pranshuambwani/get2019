
package PriorityQueue;

/**
 * This class is the implementation of priority queue It contains methods to: 1.
 * add task to queue 2. remove task from queue 3. check if queue is full 4.
 * check if queue is empty
 * 
 * @author Pranshu
 *
 */
public class PriorityQueue implements PriorityQueueInterface {

	Task[] listOfTasks;
	int size, numOfTask;

	/**
	 * Constructor initializes list of tasks
	 * 
	 * @param size
	 */
	public PriorityQueue(int size) {
		this.size = size;
		listOfTasks = new Task[size];
	}

	/**
	 * This method add a task to task list i.e. in priority queue according to
	 * priority
	 */
	@Override
	public void addTask(int job, int priority) throws AssertionError {
		if (isFull()) {
			throw new AssertionError("Queue is full");
		}
		Task task = new Task(job, priority);
		for (int count = 0; count < numOfTask; count++) {
			if (listOfTasks[count].getPriority() < priority) {
				for (int count2 = count; count2 < numOfTask - 1; count2++) {
					listOfTasks[count2 + 1] = listOfTasks[count2];
				}
				listOfTasks[count] = task;
				numOfTask++;
				return;
			}
		}
		listOfTasks[numOfTask++] = task;

	}

	/**
	 * This method removes a task from front of queue
	 * 
	 * @return priority of task removed
	 */
	@Override
	public int removeTask() {
		if (isEmpty()) {
			throw new AssertionError("No task available");
		}
		int priority = listOfTasks[0].getPriority();
		for (int count = 0; count < numOfTask; count++) {
			listOfTasks[count] = listOfTasks[count + 1];
		}
		numOfTask--;
		return priority;
	}

	/**
	 * This method checks if queue is full
	 */
	@Override
	public boolean isFull() {
		return numOfTask == size;
	}

	/**
	 * This method checks if queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return numOfTask == 0;
	}

}