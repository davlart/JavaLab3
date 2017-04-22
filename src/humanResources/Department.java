package humanResources;

/**
 * Created by ArthurArt on 13.03.2017.
 */


public class Department {
    private String name;
    private int employeesQuantity;
    private Employee[] employees;
       private final static int  DEFAULT_SIZE_ARRAY = 8;
      private final static int DEFAILT_EMPLOYESS_QUANTITY = 0;

    public Department(String name) {
        this.name = name;
        employees = new Employee[DEFAULT_SIZE_ARRAY];
        this.employeesQuantity = DEFAILT_EMPLOYESS_QUANTITY;
    }

    public Department(String name, int employeesQuantity) {
        this(name);
        employees = new Employee[employeesQuantity];
        this.employeesQuantity = 0;
    }

    private int getEmployeesQuantity(Employee[] employees) {
        int bufSum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) bufSum++;
        }
        return bufSum;
    }

    public Department(String name, Employee[] employees) {
        this(name);
        this.employees = employees;
        this.employeesQuantity = getEmployeesQuantity(employees);
    }

    public void addEmployee(Employee employee) {
        if (employeesQuantity < employees.length) {
            employees[employeesQuantity] = employee;
        } else {
            employeesQuantityArrayIncrease(employees);
            employees[employeesQuantity] = employee;
        }
        employeesQuantity++;

    }

    private void employeesQuantityArrayIncrease(Employee[] employees) {
        Employee[] newEmployees;
        if (employees.length != 0) newEmployees = new Employee[employees.length * 2];
        else newEmployees = new Employee[2];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        this.employees = newEmployees;

    }


    public boolean deleteEmployee(String ferstName, String secondName) {
        int j = 0;
        boolean boolBuf = false;
        for (int i = 0; i < employeesQuantity; i++, j++) {

            if ((employees[i].getFerstName().equals(ferstName)) && (employees[i].getSecondName().equals(secondName))) {
                j++;
                employeesQuantity--;
                boolBuf = true;
            }
            employees[i] = employees[j];

        }

        if (boolBuf) employees[employeesQuantity + 1] = null;
        return boolBuf;
    }

    public int getEmployeesQuantity() {
        return employeesQuantity;
    }

    public Employee[] getEmployees() {

        return getCoopyArrayEmploeyees();
    }

    public Employee[] getEmployees(String jobPosition) {
        Employee[] employeesBuf = new Employee[employeesQuantity];
        int count = 0;
        for (int i = 0; i < employeesQuantity; i++) {
            if (employees[i].getJobPosition().equals(jobPosition)) {
                employeesBuf[count] = employees[i];
                count++;
            }
        }
        Employee[] getEmpoyees = new Employee[count];
        System.arraycopy(employeesBuf, 0, getEmpoyees, 0, count);
        return getEmpoyees;
    }

    private Employee[] getCoopyArrayEmploeyees() {
        Employee[] employeesArrayCoopy = new Employee[employeesQuantity];
        System.arraycopy(employees, 0, employeesArrayCoopy, 0, employeesQuantity);


        return employeesArrayCoopy;
    }


    public Employee[] getEmployeesArraySorted() {
        Employee[] employeesArraySorted = getCoopyArrayEmploeyees();
        Employee empBuf;

        for (int i = 0; i < employeesQuantity; i++) {
            for (int j = 0; j < employeesQuantity - 1; j++) {
                if (employeesArraySorted[j].getSalary() < employeesArraySorted[j + 1].getSalary()) {
                    empBuf = employeesArraySorted[j];
                    employeesArraySorted[j] = employeesArraySorted[j + 1];
                    employeesArraySorted[j + 1] = empBuf;
                }
            }
        }
        return employeesArraySorted;
    }


    public String getName() {
        return name;
    }


    public int getEmployeesQuantity(String jobPosition) {
        int count = 0;
        for (int i = 0; i < employeesQuantity; i++) {
            if (employees[i].getJobPosition().equals(jobPosition)) count++;
        }
        return count;
    }

    public boolean foundEmployee(String FerstName, String SecondName) {
        for (int i = 0; i < employeesQuantity; i++) {
            if ((employees[i].getFerstName().equals(FerstName)) && (employees[i].getSecondName().equals(SecondName)))
                return true;
        }
        return false;
    }

    public Employee getBestEmployee() {
        Employee bufEmployeeWithMaxSalary = employees[0];
        for (int i = 1; i < employeesQuantity; i++) {
            if (employees[i].getSalary() > bufEmployeeWithMaxSalary.getSalary())
                bufEmployeeWithMaxSalary = employees[i];
        }
        return bufEmployeeWithMaxSalary;
    }


}
