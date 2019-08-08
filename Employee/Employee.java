package Employee;

/**
 * Employee Class
 * 
 * @author Vatsal
 *
 */
public class Employee {
	public String name;
	public int age;
	public double salary;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * Getter function for name
	 * 
	 * @return Name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter function for age
	 * 
	 * @return Age of the employee
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Getter function for salary
	 * 
	 * @return Salary of the employee
	 */
	public double getSalary() {
		return salary;
	}
}