package humanResources;

/**
 * Created by ArthurArt on 07.05.2017.
 */
public interface GroupsManager {
    public int getGroupsQuantity();
    public boolean remove(String name);
    public EmployeeGroup getEmployeeGroup(String name);
    public EmployeeGroup[] getEmployeeGroups();
    public int getAllGroupEmployeesQuantity();
    public EmployeeGroup getEmployeeGroupEmployee(String firstName, String secondName);
}
