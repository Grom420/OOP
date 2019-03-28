package humanresources;

public class ProjectsManager implements GroupsManager {

    private ProjectsNode head;
    private ProjectsNode tail;
    private int size;

    public ProjectsManager(){}

    public ProjectsManager(EmployeeGroup[] employeeGroups){
        for (int i = 0; i < employeeGroups.length; i++) {
            add(employeeGroups[i]);
        }
    }

    @Override
    public int employeesQuantity() {
        return 0;
    }

    @Override
    public int groupsQuantity() {
        return 0;
    }

    public void add(EmployeeGroup employee) {
        ProjectsNode a = new ProjectsNode();
        a.value = employee;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String name) {
        return null;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups() {
        return new EmployeeGroup[0];
    }

    @Override
    public int employeesQuantity(JobTitilesEnum jobTitle) {
        return 0;
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String firstName, String secondName) {
        return null;
    }

    @Override
    public Employee mostValuableEmployee() {
        return null;
    }

    @Override
    public void remove(String groupName) {

    }

    @Override
    public int remove(EmployeeGroup group) {
        return 0;
    }
}
