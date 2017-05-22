package humanResources;

import java.util.Objects;

/**
 * Created by ArthurArt on 25.04.2017.
 */
public interface EmployeeGroup {
    public void add(Employee employee);
    public Employee[] sortedEmployees();
    public Employee[] getEmployees();
    public int employeeQuantity();
    public boolean remove(String firstName,String secondName);
    public boolean remove(Employee employee);
    public Employee getEmployee(String firstName,String secondName);
    public String getName();
    public void setName(String  name);
    public Employee  mostVluableEmployee();
    public String toString();
    public boolean equals(Object obj);
    public int hashCode();



}
