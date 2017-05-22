package humanResources;

/**
 * Created by admincomp on 05.03.2017.
 */
public class DepartmentsManager implements GroupsManager{
    private String name;
    private Department[] departments;
    private int departmentQuantity;


    private static final int DEFAULT_ARRAY_SIZE = 4;

    public DepartmentsManager(String name){
        this(name, new Department[DEFAULT_ARRAY_SIZE]);
    }

    public DepartmentsManager(String name, Department[] departments) {
        this.name = name;
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

    private void departmentQuantityArrayIncrease(EmployeeGroup[] department) {
        Department[] newDepartments;
        if (departments.length != 0) newDepartments = new Department[department.length * 2];
        else newDepartments = new Department[2];
        System.arraycopy(department, 0, newDepartments, 0, department.length);
        this.departments = newDepartments;
    }

 

    @Override
    public boolean remove(String name) {
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

    public String getName() {
    return name;
    }

    public EmployeeGroup getDepartment(String name) {
        for (int i = 0; i < departmentQuantity; i++) {
            if (departments[i].getName().equals(name))
                return departments[i];
        }
        return null;
    }

    public EmployeeGroup[] getDepartments() {
        return departments;
    }
    @Override
    public int getGroupsQuantity() {
        return departmentQuantity;
    }

     

    public int getEmployeesQuantity() {
        int count = 0;
        for (int i = 0; i < departmentQuantity; i++) {
            count += departments[i].employeeQuantity();
        }
        return count;
    }
    
    public int getEmployeesQuantity(String jobTitle) {
        int count = 0;
        for (int i = 0; i < departmentQuantity; i++) {
            count += departments[i].employeeQuantity();

        }
        return count;
    }





    public Employee mostVluableEmployee() {

        Employee bufEmployeeWithMaxSalare = departments[0].mostVluableEmployee();
        for (int i = 1; i < departmentQuantity; i++) {
            if (departments[i].mostVluableEmployee().getSalary() > bufEmployeeWithMaxSalare.getSalary())
                bufEmployeeWithMaxSalare = departments[i].mostVluableEmployee();
        }
        return bufEmployeeWithMaxSalare;
    }

 
 
    @Override
    public EmployeeGroup getEmployeeGroup(String name) {
        for(EmployeeGroup eg : departments){
            if(eg.getName().equals(name)){
                return eg;
            }
        }
        return null;
    }

    @Override
    public Department[] getEmployeeGroups() {
        return departments;
    }

    @Override
    public int getAllGroupEmployeesQuantity() {
        int result = 0;
        for(EmployeeGroup eg : departments){
            result+=eg.employeeQuantity();
        }
        return result;
    }

    @Override
    public EmployeeGroup getEmployeeGroupEmployee(String firstName, String secondName) {
        for(EmployeeGroup eg : departments){
            if(eg.getEmployee(firstName,secondName)!=null)
                return eg;
        }
        return null;
    }




    public int getDepartmentQuantity(){
        return departmentQuantity;
    }


//    private Employee[] getCoopyArrayEmploeyees() {
//        Employee[] employeesArrayCoopy = new Employee[employeesQuantity];
//        System.arraycopy(employees, 0, employeesArrayCoopy, 0, employeesQuantity);
//
//
//        return employeesArrayCoopy;
//    }

    @Override
    public String toString() {
        String result = "" + "humanResources.Department " + getName() + " Кол-во департаментов " +
                getDepartmentQuantity()  ;
        Employee[] emp;
        for(int i=0;i<departmentQuantity;i++) {
            emp = departments[i].getEmployees();
            for (int j = 0; j < departments[i].getEmployeesQuantity(); j++) {
                result += " " + emp.toString();
            }

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
        DepartmentsManager departmentsManager = (DepartmentsManager) obj;


        if((obj.toString().equals(toString()))&&( getDepartmentQuantity() == departmentsManager.getDepartmentQuantity()))
        {
            Department[] dempThis = getEmployeeGroups();
            Department[] dempObj = departmentsManager.getEmployeeGroups();
            for(int i=0;i<departmentQuantity;i++) {
                 if(!dempThis[i].equals(dempObj[i]))
                     return false;


            }
        }






        return true ;

    }

    @Override
    public int hashCode() {
        int result = 0;
        Department[] dempThis = getEmployeeGroups();
        for(int i=0;i<departmentQuantity;i++) {
          result ^= dempThis[i].hashCode();
        }

        return result ^= name.hashCode() ^ departmentQuantity ;
    }


}