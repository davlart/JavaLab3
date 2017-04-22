
import humanResources.Department;
import humanResources.Employee;
import humanResources.Organization;

import java.util.Random;


/**
 * Created by ArthurArt on 13.03.2017.
 */



public class NewTestClass {

    public static void toScrean(Employee[] testEmploees ){

        for (int i = 0; i < testEmploees.length; i++) {

            System.out.println(testEmploees[i].toString());
        }
    }
    public static Employee[] createArrayEmployee(Employee[] employees)
    {
        Employee[] buf;

        Random rnd = new Random();
        for (int i = 0; i <employees.length ; i++) {
            employees[i] = new Employee("Art"+i,"dart"+i,"Раб",rnd.nextInt(10000));
        }
        buf= employees;
        return buf;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
     Employee[] testEmploees = new Employee[15];
        for (int i = 0; i < 10; i++) {
            testEmploees[i] = new Employee("Art"+i,"dart"+i,"Раб",rnd.nextInt(10000));
            System.out.println(testEmploees[i].toString());
        }

         testEmploees[5].setJobPosition("Главарь");
        testEmploees[2].setJobPosition("Зам Главаря");
        Department testDepartment = new Department("Образования",testEmploees);

        System.out.print(testDepartment.getName()+" "+
                testDepartment.getEmployeesQuantity()+" "+
                testDepartment.getEmployeesQuantity("Раб")+" "+
                testDepartment.getBestEmployee().getFerstName());

        Employee newEmp = new Employee("Гарри","Potter","Super worker",99999);

        System.out.println(testDepartment.deleteEmployee("Art4","dart4"));

        testDepartment.addEmployee(newEmp);
     //   toScrean(testDepartment.getEmployees());
      // toScrean(testDepartment.getEmployees("Главарь"));
        toScrean(testDepartment.getEmployeesArraySorted());
        System.out.println(testDepartment.getBestEmployee().toString());

        Department[] testArDp = new Department[3];
        Employee[] empAr  ;
        for (int i = 0; i <3 ; i++) {
            empAr = new Employee[10];
             testArDp[i] = new Department("Department"+i,createArrayEmployee(empAr));

        }
         Organization testO10N = new Organization("Google",testArDp);
        testO10N.addDepartment(testDepartment);
       // toScrean(testO10N.getDepartment("Гарри","Potter").getEmployees() );
          System.out.println(testO10N.getBestEmployee().getFerstName());

        System.out.println(  testO10N.getEmployeesQuantity() );
        System.out.println(  testO10N.getEmployeesQuantity("Super worker") );
        System.out.println(  testO10N.getEmployeesQuantity("Раб") );
       System.out.println(testO10N.getDepartment("Образования").getName());
       toScrean(testO10N.getDepartment("Образования").getEmployees());
        toScrean(testO10N.getDepartment("Гарри","Potter").getEmployees());
    }
}
