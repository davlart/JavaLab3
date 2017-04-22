//
//import humanResources.Department;
//import humanResources.Employee;
//import humanResources.Organization;
//
//import java.util.Random;
//
//
///**
// * Created by ArthurArt on 13.03.2017.
// */
//public class TestAllClass {
//
//    public static void main(String[] args) {
//     Department myD = new Department("Aleksia");
//        Department myD1 = new Department("Aleksia");
//        Random rnd = new Random();
//        Department[] MySecondArrayDp = new Department[3];
//        Employee art;
//
//
//        for (int i = 0; i < 3; i++) {
//            MySecondArrayDp[i]=new Department("MyArtDp"+i);
//            for (int j = 0; j < 10 ; j++) {
//                art = new  Employee("ArtD"+j,"DartD"+j);
//                MySecondArrayDp[i].addEmployee(art);
//                MySecondArrayDp[i].employees[j].setWage(rnd.nextInt(100000));
//                MySecondArrayDp[i].employees[j].setPosition("Раб");
//                System.out.println(MySecondArrayDp[i].employees[j].getName()+
//                        " "+MySecondArrayDp[i].employees[j].getFename() +" "+
//                        MySecondArrayDp[i].employees.length+" "
//                        + MySecondArrayDp[i].employees[j].getWage()
//                        +" "+ MySecondArrayDp[i].employees[j].getPosition());
//            }
//            System.out.println();
//        }
//
//
//
//        Organization google = new Organization("Google",MySecondArrayDp );
//
//         System.out.println(google.NumberOfEmployeesHoldingPosition("Раб"));
//
//        for (int i = 0; i <10 ; i++)
//        {
//              art = new Employee("Art"+i,"Dart"+i);
//            myD.addEmployee(art);
//            myD.employees[i].setWage(rnd.nextInt(100000));
//          //System.out.println(myD.employees[i].getName()+" "+myD.employees[i].getFename() +" "+myD.employees.length+" "+ myD.employees[i].getWage());
//        }
//
//        myD1 = myD;
//        myD.WageSorting();
//        for (int i = 0; i <10 ; i++)
//        {
//            System.out.println(myD1.employees[i].getName()+" "+myD1.employees[i].getFename() +" "+myD1.employees.length+" "+ myD1.employees[i].getWage());
//        }
//
//
//
//
//        System.out.println( myD.deleteEmployee("Art6","Dart6"));
//
//        for (int i = 0; i <myD.getNumberOfEmployees() ; i++) {
//
//            System.out.println(myD.employees[i].getName()+" "+myD.employees[i].getFename() +" "+myD.employees.length);
//        }
//
//
//
//
//
//
//
//    }
//}
