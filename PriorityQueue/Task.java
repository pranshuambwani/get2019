package PriorityQueue;

/**
 * Class Task contains 2 attributes: job and priority
 * 
 * @author Pranshu
 *
 */
public class Task {
	int job, priority;

	/**
	 * Constructor initializes job and priority
	 * 
	 * @param job
	 * @param priority
	 */
	public Task(int job, int priority) {
		this.job = job;
		this.priority = priority;
	}

	/**
	 * This method returns job
	 * 
	 * @return job
	 */
	public int getJob() {
		return job;
	}

	/**
	 * This method returns priority
	 * 
	 * @return priority
	 */
	public int getPriority() {
		return priority;
	}

}