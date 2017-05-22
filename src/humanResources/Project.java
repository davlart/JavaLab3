package humanResources;

/**
 * Created by ArthurArt on 25.04.2017.
 */
public class Project implements EmployeeGroup{
 private Employee[] employees;
 private String name;

    private int size;
    private static final int DEFAULT_COUNT = 0;
    LinkedList<Employee> list;


    public Project(String name) {
        this(name,new Employee[DEFAULT_COUNT]);
    }

    public Project(String name,Employee[] employees) {
        this.name = name;
        list = new LinkedList<>();
        list.addAll(employees);
    }

 public String getName(){
     return  name;
 }

 public void setName(String name){
     this.name = name;
 }

    @Override
    public Employee mostVluableEmployee()
    {

        Employee bufEmployeeWithMaxSalary = list.next();
        Employee temp = null;
        for(int i = 1; i< list.count(); i++)
        {
            temp = list.next();
            if(temp.getSalary() > bufEmployeeWithMaxSalary.getSalary())
                bufEmployeeWithMaxSalary =temp;
        }
        list.reset();
        return bufEmployeeWithMaxSalary;
    }



    public boolean deleateEmployee(String firstName,String secondName){
        return false;
    }

 public boolean deleateEmployee(Employee employee){
     return false;
 }

 public Employee getBestEmployee(){
     return null;
 }



    @Override
    public void add(Employee employee) {
        list.add(employee);
    }

    @Override
    public Employee[] sortedEmployees() {
        Employee[] myEmployees = getEmployees();
        for(int i = myEmployees.length-1 ; i > 0 ; i--)
            for(int j = 0 ; j < i ; j++){
                if( myEmployees[j].getSalary()<myEmployees[j+1].getSalary() ){
                    Employee tmp = myEmployees[j];
                    myEmployees[j] = myEmployees[j+1];
                    myEmployees[j+1] = tmp;
                }
            }
        return myEmployees;
    }

    public Employee[] getEmployees(){
        Employee[] bufEmployees = new Employee[list.count()];
        for(int i=0; i<list.count(); i++)
            bufEmployees[i] = list.next();
        list.reset();
        return bufEmployees;
 }

    @Override
    public int employeeQuantity() {
        return list.count();
    }

    @Override
    public boolean remove(String firstName, String secondName) {
        return list.delete(getEmployee(firstName,secondName));
    }

    @Override
    public boolean remove(Employee employee) {
        return list.delete(employee);
    }

    @Override
    public Employee getEmployee(String firstName, String secondName) {
        Employee temp;
        for(int i=0; i<list.count(); i++){
            temp = list.next();
            if(temp.getFirstName().equals(firstName)&&temp.getSecondName().equals(secondName)){
                list.reset();
                return temp;
            }
        }
        list.reset();
        return null;
    }
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }

    public Employee[] getEmployeesArraySorted() {
     return null;
 }

    public int getEmployeeQuantity(){
        return list.count();
    }

    @Override
    public String toString() {

        String result = "" + "Project " + getName() + " " + getSize();
        for(int i=0;i<getEmployeeQuantity();i++)
        {
            result += " " + getEmployees()[i].toString();
        }
        return result;
    }


    //*
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;

        if(getClass()!=obj.getClass())
            return  false;

        Project project = (Project) obj;

        if(!project.toString().equals(this.toString()) &&
                project.getEmployeeQuantity() != project.getEmployeeQuantity())
            return false;
        return true ;
    }



    @Override
    public int hashCode() {
        int result = 0;
        result = name.hashCode()^size;
        for(int i=0;i<list.count();i++)
        {
            result ^= list.next().hashCode();
        }
        list.reset();
        return result;
    }
}
