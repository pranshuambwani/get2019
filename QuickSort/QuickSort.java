package QuickSort;

import java.util.*;

public class QuickSort {
	
	static LinkedList<Employee> employeeList = new LinkedList<Employee>();

	public static void swapList(Employee emp1, Employee emp2) {
		Employee tempObj = new Employee("Z", 25, 20000);
		tempObj.name = emp1.getName();
		tempObj.age = emp1.getAge();
		tempObj.salary = emp1.getSalary();

		emp1.name = emp2.getName();
		emp1.age = emp2.getAge();
		emp1.salary = emp2.getSalary();

		emp2.name = tempObj.getName();
		emp2.age = tempObj.getAge();
		emp2.salary = tempObj.getSalary();
	}

	public static int partition(LinkedList<Employee> list, int low, int high) {
		int i = low - 1;
			Employee highNode = list.get(high);
			for (int loop = low; loop < high; loop++) {
				Employee node = list.get(loop);
				if ((node.getSalary() > highNode.getSalary())
						|| ((node.getSalary() == highNode.getSalary()) && (node
								.getAge() < highNode.getAge()))) {
					i++;
					Employee nodeTemp = list.get(i);
					swapList(nodeTemp, node);
				}
			}
			Employee nodePar = list.get(i + 1);
			swapList(nodePar, highNode);
		
		return i + 1;
	}

	public static void sort(LinkedList<Employee> list, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(list, low, high);
			sort(list, low, partitionIndex - 1);
			sort(list, partitionIndex + 1, high);
		}
	}

	public static void main(String args[]) {
		Employee emp1 = new Employee("A", 30, 20000);
		Employee emp2 = new Employee("B", 35, 30000);
		Employee emp3 = new Employee("C", 40, 40000);
		Employee emp4 = new Employee("D", 45, 50000);

		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		sort(employeeList, 0, 3);
		for (int loop = 0; loop < employeeList.size(); loop++) {
			System.out.println(employeeList.get(loop).getAge() + " "
					+ employeeList.get(loop).getName() + " "
					+ employeeList.get(loop).getSalary());
		}
	}
}