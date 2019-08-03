package Employee;

import java.util.Comparator;

/**
 * class to sort the list by employee name
 * 
 * @author Pranshu
 *
 */
public class SortByName implements Comparator<Employee> {
    /**
     * method to sort the list of employees using name by ascending order
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {

        return employee1.getEmpName().compareTo(employee2.getEmpName());

    }

}