package humanResources;


public class ProjectsManager implements GroupsManager{
    private LinkedList<Project> list;
    Project[] groups;


    public ProjectsManager() {
        this(new Project[0]);
    }


    public ProjectsManager(Project[] departmentsManager)
    {
        list = new LinkedList<>();
        list.addAll(departmentsManager);
    }

    public void add(Project Project){
        list.add(Project);
    }

    public int getGroupsQuantity(){
        return list.count();
    }


    public boolean remove(String name){
        Project eg;
        for(int i=0;i<list.count();i++){
            eg = list.next();
            if(eg.getName().equals(name)){
                list.delete(eg);
                list.reset();
                return true;
            }
        }
        list.reset();
        return false;
    }


    public Project getEmployeeGroup(String name){
        Project eg;
        for(int i=0;i<list.count();i++){
            eg = list.next();
            if(eg.getName().equals(name)){
                list.reset();
                return eg;
            }
        }
        list.reset();
        return null;
    }



    public Project[] getEmployeeGroups(){
        Project[] bufEmployeeGroup = new Project[list.count()];
        for(int i=0;i<list.count();i++) {
            bufEmployeeGroup[i] = list.next();
        }
        list.reset();
        return bufEmployeeGroup;
    }



    public int getAllGroupEmployeesQuantity(){
        int counter = 0;
        for(int i=0;i<list.count();i++) {
            counter += list.next().employeeQuantity();
        }
        list.reset();
        return counter;
    }



    public Project getEmployeeGroupEmployee(String firstName, String secondName){
        Project eg;
        for(int i=0; i<list.count(); i++){
            eg = list.next();
            if(eg.getEmployee(firstName,secondName)!=null)
                return eg;
        }
        return null;
    }

    @Override
    public String toString(){
        String result = "";
        Project[] projects = getEmployeeGroups();
        for (int i = 0; i <projects.length  ; i++)
        {
              result = "" + "Project " + projects[i].getName() + " " + projects[i].getSize();
            Employee[] emp = projects[i].getEmployees();
            for (int j = 0; j < projects[i].getEmployeeQuantity(); j++) {
                result += " " +emp[j].toString();
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

        if(getClass()!=obj.getClass())
            return  false;

        ProjectsManager  projectsManager = (ProjectsManager) obj;

        if(!projectsManager.toString().equals( toString()) &&
                 getEmployeeGroups().length != projectsManager.getEmployeeGroups().length)
            return false;


        return true ;




    }
    @Override
    public int hashCode() {
        int result = 0;
        Project[] projects = getEmployeeGroups();
         for(int i=0;i<projects.length;i++)
        {
            result ^= projects[i].hashCode();

        }

        return result;
    }
}
