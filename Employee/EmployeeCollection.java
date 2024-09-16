package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * employee collection class containing the list of all employees with details
 * 
 * @author Pranshu
 *
 */
public class EmployeeCollection {
    List<Employee> employeeCollection;

    public EmployeeCollection() {
        employeeCollection = new ArrayList<Employee>();
        employeeCollection.add(new Employee("a", 8, "JAIPUR"));
        employeeCollection.add(new Employee("b", 12, "AJMER"));
        employeeCollection.add(new Employee("c", 3, "DELHI"));
        employeeCollection.add(new Employee("d", 4, "JAIPUR"));
        employeeCollection.add(new Employee("e", 5, "DELHI"));
    }

    /**
     * method to add employee details to the collection
     * 
     * @param empName
     * @param empId
     * @param empAddress
     */
    public boolean addEmployee(String empName, int empId, String empAddress) throws AssertionError{
        
        boolean check = true;
        for (Employee employee : employeeCollection) {
            if (employee.getempId() == empId) {
                check = false;
                throw new AssertionError("id exsists");
            }
        }
        if (check)
            employeeCollection.add(new Employee(empName, empId, empAddress));
        return check;
    }

    /**
     * 
     * @return list of employees
     */
    public List<Employee> getList() {
        return employeeCollection;
    }
}