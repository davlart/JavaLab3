package humanResources;

/**
 * Created by ArthurArt on 13.03.2017.
 */
public class Organization {
    private String name;
    private Department[] departments;
    private int departmentQuantity;


    Organization(String name) {
        this.name = name;
    }

    public Organization(String name, Department[] departments) {
        this(name);
        this.departments = departments;
        this.departmentQuantity = departments.length;
    }

    public void addDepartment(Department department) {
        if (departmentQuantity < departments.length) {
            departments[departmentQuantity] = department;
        } else {
            departmentQuantityArrayIncrease(departments);
            departments[departmentQuantity] = department;
        }
        departmentQuantity++;
    }

    private void departmentQuantityArrayIncrease(Department[] department) {
        Department[] newDepartments;
        if (departments.length != 0) newDepartments = new Department[department.length * 2];
        else newDepartments = new Department[2];
        System.arraycopy(department, 0, newDepartments, 0, department.length);
        this.departments = newDepartments;
    }

    public boolean deleteDepartment(String name) {
        int j = 0;
        boolean boolBuf = false;
        for (int i = 0; i < departmentQuantity; i++, j++) {

            if (departments[i].getName().equals(name)) {
                j++;
                departmentQuantity--;
                boolBuf = true;
            }
            departments[i] = departments[j];

        }

        if (boolBuf) departments[departmentQuantity + 1] = null;
        return boolBuf;
    }


    public Department getDepartment(String name) {
        for (int i = 0; i < departmentQuantity; i++) {
            if (departments[i].getName().equals(name))
                return departments[i];
        }
        return null;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public int getDepartmentQuantity() {
        return departmentQuantity;
    }


    public int getEmployeesQuantity() {
        int count = 0;
        for (int i = 0; i < departmentQuantity; i++) {
            count += departments[i].getEmployeesQuantity();
        }
        return count;
    }

    public int getEmployeesQuantity(String jobPosition) {
        int count = 0;
        for (int i = 0; i < departmentQuantity; i++) {
            count += departments[i].getEmployeesQuantity(jobPosition);

        }
        return count;
    }


    public Department getDepartment(String FerstName, String SecondName) {
        for (int i = 0; i < departmentQuantity; i++) {
            if (departments[i].foundEmployee(FerstName, SecondName)) return departments[i];

        }
        return null;
    }


    public Employee getBestEmployee() {

        Employee bufEmployeeWithMaxSalare = departments[0].getBestEmployee();
        for (int i = 1; i < departmentQuantity; i++) {
            if (departments[i].getBestEmployee().getSalary() > bufEmployeeWithMaxSalare.getSalary())
                bufEmployeeWithMaxSalare = departments[i].getBestEmployee();
        }
        return bufEmployeeWithMaxSalare;
    }


}
