package Employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class EmployeeTest {
    EmployeeCollection employeeCollection;

    @Test(expected = AssertionError.class)
    public void test() {
        employeeCollection = new EmployeeCollection();
        NaturalSorting sort = new NaturalSorting();
        employeeCollection.addEmployee("g", 4, "kanpur");
        employeeCollection.addEmployee("h", 41, "jaipur");
        employeeCollection.addEmployee("i", 41, "kanpur");
        Collections.sort(employeeCollection.getList(), sort);

        List<Employee> listcheck = new ArrayList<Employee>();
        for (int loop = 0; loop < listcheck.size(); loop++) {
            assertEquals(listcheck.get(loop).toString(), employeeCollection
                    .getList().get(loop).toString());
        }

    }
}