package Employee;

import java.util.Comparator;

/**
 * class to sort the list by employee id
 * 
 * @author Pranshu
 *
 */
public class NaturalSorting implements Comparator<Employee> {
    /**
     * method to sort the list of employees using unique id
     */
    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (employee1.getempId() > ((employee2.getempId())))
            return 1;
        if (employee1.getempId() < ((employee2.getempId())))
            return -1;
        return 0;

    }
}