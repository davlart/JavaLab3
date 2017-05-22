package humanResources;

import java.util.Objects;

/**
 * Created by ArthurArt on 13.03.2017.
 */


public class Department implements EmployeeGroup {
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

    @Override
    public void add(Employee employee) {
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

    @Override
    public boolean remove(String firstName, String secondName) {
        int j = 0;
        boolean boolBuf = false;
        for (int i = 0; i < employeesQuantity; i++, j++) {

            if ((employees[i].getFirstName().equals(firstName)) && (employees[i].getSecondName().equals(secondName))) {
                j++;
                employeesQuantity--;
                boolBuf = true;
            }
            employees[i] = employees[j];

        }

        if (boolBuf) employees[employeesQuantity + 1] = null;
        return boolBuf;
    }

    @Override
    public boolean remove(Employee employee) {
        int j = 0;
        boolean boolBuf = false;
        for (int i = 0; i < employeesQuantity; i++) {
            if(employees[i].equals(employee)) {
                j++;
                employeesQuantity--;
                boolBuf = true;
            }
        }
        if (boolBuf) employees[employeesQuantity + 1] = null;
        return boolBuf;
    }

    public void removeAll(JobTitlesEnum jobTitle){
        for (int i = 0; i <employeesQuantity ; i++) {
            if(employees[i].getJobTitle().equals(jobTitle) )
                remove(employees[i]);
        }
    }


    public Employee getEmployee(String firstName, String secondName){
        for (int i = 0; i < employeesQuantity; i++)

            if ((employees[i].getFirstName().equals(firstName)) && (employees[i].getSecondName().equals(secondName)))
                return employees[i];

          return  null;
    }





    @Override
    public int employeeQuantity() {
        return employeesQuantity;
    }





    public Employee[] getEmployees() {

        return getCoopyArrayEmploeyees();
    }







    public Employee[] getEmployees(String jobPosition) {
        Employee[] employeesBuf = new Employee[employeesQuantity];
        int count = 0;
        for (int i = 0; i < employeesQuantity; i++) {
            if (employees[i].getJobTitle().equals(jobPosition)) {
                employeesBuf[count] = employees[i];
                count++;
            }
        }
        Employee[] getEmpoyees = new Employee[count];
        System.arraycopy(employeesBuf, 0, getEmpoyees, 0, count);
        return getEmpoyees;
    }
//
//    public  JobTitlesEnum[] getJobTitles(){
//        JobTitlesEnum[] jobTitlesEnumBuf = new JobTitlesEnum[JobTitlesEnum.values().length];
//        int count = 0;
//        for (int i = 0; i < employeesQuantity; i++) {
//            if (employees[i].getJobTitles().equals(jobTitles)) {
//                JobTitlesEnum[count] = JobTitlesEnum[i];
//                count++;
//            }
//        }
//        Employee[] getEmpoyees = new Employee[count];
//        System.arraycopy(employeesBuf, 0, getEmpoyees, 0, count);
//        return getEmpoyees;
//    }


    private Employee[] getCoopyArrayEmploeyees() {
        Employee[] employeesArrayCoopy = new Employee[employeesQuantity];
        System.arraycopy(employees, 0, employeesArrayCoopy, 0, employeesQuantity);


        return employeesArrayCoopy;
    }


    @Override
    public Employee[] sortedEmployees() {
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

    public void setName(String name){
        this.name = name;
    }



    public int getEmployeesQuantity(String jobPosition) {
        int count = 0;
        for (int i = 0; i < employeesQuantity; i++) {
            if (employees[i].getJobTitle().equals(jobPosition)) count++;
        }
        return count;
    }
    public int getEmployeesQuantity() {
        return employeesQuantity;
    }

    public boolean foundEmployee(String FirstName, String SecondName) {
        for (int i = 0; i < employeesQuantity; i++) {
            if ((employees[i].getFirstName().equals(FirstName)) && (employees[i].getSecondName().equals(SecondName)))
                return true;
        }
        return false;
    }

    @Override
    public Employee mostVluableEmployee() {
        Employee bufEmployeeWithMaxSalary = employees[0];
        for (int i = 1; i < employeesQuantity; i++) {
            if (employees[i].getSalary() > bufEmployeeWithMaxSalary.getSalary())
                bufEmployeeWithMaxSalary = employees[i];
        }
        return bufEmployeeWithMaxSalary;
    }

    public Employee getBestEmployee() {
        Employee bufEmployeeWithMaxSalary = employees[0];
        for (int i = 1; i < employeesQuantity; i++) {
            if (employees[i].getSalary() > bufEmployeeWithMaxSalary.getSalary())
                bufEmployeeWithMaxSalary = employees[i];
        }
        return bufEmployeeWithMaxSalary;
    }
    @Override
    public String toString() {
        String result = "" + "humanResources.Department " + getName() + " " + employeesQuantity;
        Employee[] emp = getEmployees();
        for(int i=0;i<employeeQuantity();i++)
        {
            result += " " + emp[i].toString();
        }
        return result;
    }


    @Override
         public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;

        if (getClass() != obj.getClass())
            return false;
        Department department = (Department) obj;
        Employee[] empObj = department.getEmployees();
        Employee[] empThis = getEmployees();
        if(!department.toString().equals(this.toString()) && department.employeeQuantity() != this.employeeQuantity())
        {
            boolean flag = true;
            for(int i=0; i<department.employeeQuantity();i++){
                for(int j=0;j<this.employeeQuantity();j++)
                {
                    if(empObj[i].equals(empThis[j]))
                    {
                        flag  = true;
                    }
                    else{ flag = false; break;}
                }
            }
            return flag;
        }



       return false;

    }

    @Override
    public int hashCode() {
        int result = 0;
        for(Employee emp : employees)
            result ^= emp.hashCode();
        return result ^= name.hashCode() ^ employeesQuantity;
    }

}
