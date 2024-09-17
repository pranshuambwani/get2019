package Employee;

import java.util.LinkedList;

/**
 * Sorting Employees Class
 * 
 * @author Pranshu
 *
 */
public class SortEmployees {
	public static LinkedList<Employee> employeeList = new LinkedList<Employee>();

	/**
	 * Default Constructor
	 * 
	 * @param employeeList
	 */
	public SortEmployees(LinkedList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * This method sort the employees on the basis of salaries and age
	 * 
	 * @param employeeList
	 * @return Sorted List of Employees
	 */
	public static LinkedList<Employee> sortEmployeeList(
			LinkedList<Employee> employeeList) {
		if (employeeList == null)
			throw new AssertionError("Invalid Employee List");
		Employee tempObj = new Employee(null, 0, 0);

		LinkedList<Employee> sortedList = employeeList;
		// Sorting Algorithm
		for (int loop = 0; loop < sortedList.size(); loop++) {
			for (int loop2 = loop + 1; loop2 < sortedList.size(); loop2++) {
				if ((sortedList.get(loop).getSalary() < sortedList.get(loop2)
						.getSalary())
						|| (sortedList.get(loop).getSalary() == sortedList.get(
								loop2).getSalary() && sortedList.get(loop)
								.getAge() > sortedList.get(loop2).getAge())) {
					// Swapping two objects
					tempObj.name = sortedList.get(loop).getName();
					tempObj.age = sortedList.get(loop).getAge();
					tempObj.salary = sortedList.get(loop).getSalary();

					sortedList.get(loop).name = sortedList.get(loop2).getName();
					sortedList.get(loop).age = sortedList.get(loop2).getAge();
					sortedList.get(loop).salary = sortedList.get(loop2)
							.getSalary();

					sortedList.get(loop2).name = tempObj.getName();
					sortedList.get(loop2).age = tempObj.getAge();
					sortedList.get(loop2).salary = tempObj.getSalary();
				}
			}
		}
		return sortedList;
	}

	public static void main(String args[]) {
		Employee obj1 = new Employee("A", 25, 10000);
		Employee obj2 = new Employee("B", 30, 20000);
		Employee obj3 = new Employee("C", 22, 10000);
		employeeList.add(obj1);
		employeeList.add(obj2);
		employeeList.add(obj3);
		LinkedList<Employee> check = sortEmployeeList(employeeList);
		for (int loop = 0; loop < check.size(); loop++) {
			System.out.println(check.get(loop).getName() + " "
					+ check.get(loop).getAge() + " "
					+ check.get(loop).getSalary());
		}
	}
}