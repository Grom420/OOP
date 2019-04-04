package humanresources;

public interface GroupsManager extends Iterable<EmployeeGroup> {

    public int employeesQuantity();
    public int groupsQuantity();
    public void add(EmployeeGroup group) throws AlreadyAddedException;
    public EmployeeGroup getEmployeeGroup(String name);
    public EmployeeGroup[] getEmployeesGroups();
    //todo сделай в классах итераторы и часть логики (одинаоковй) можно будет поместить в интерфейс. Как в этом методе
    default int employeesQuantity(JobTitilesEnum jobTitle) {
            int employeesQuantity = 0;
            for (EmployeeGroup group : this) {
                employeesQuantity += group.employeesQuantity(jobTitle);
            }
            return employeesQuantity;
    }
    public EmployeeGroup getEmployeeGroup(String firstName, String secondName);
    public Employee mostValuableEmployee();
    public boolean remove(String groupName);
    public int remove(EmployeeGroup group);
    public int countPartTimeEmployee();
    public int countFullTimeEmployee();
    public int countEmployeeTraveller();
    public Employee[] getEmployeeTraveller();

}
