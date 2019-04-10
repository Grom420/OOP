package humanresources;

public interface GroupsManager extends Iterable<EmployeeGroup> {

    public int employeesQuantity();
    public int groupsQuantity();
    public void add(EmployeeGroup group) throws AlreadyAddedException;
    default EmployeeGroup getEmployeeGroup(String name){
        for (EmployeeGroup employeeGroup : this) {
            if (employeeGroup.getName().equals(name))
                return employeeGroup;
        }
        return null;
    }
    public EmployeeGroup[] getEmployeesGroups();
    //todo сделай в классах итераторы и часть логики (одинаоковй) можно будет поместить в интерфейс. Как в этом методе(DONE)
    default int employeesQuantity(JobTitilesEnum jobTitle) {
            int employeesQuantity = 0;
            for (EmployeeGroup group : this) {
                employeesQuantity += group.employeesQuantity(jobTitle);
            }
            return employeesQuantity;
    }
    default EmployeeGroup getEmployeeGroup(String firstName, String secondName){
        for(EmployeeGroup employeeGroup : this) {
            if(employeeGroup.getEmployee(firstName, secondName) != null)
                return employeeGroup;
        }
        return null;
    }
    public Employee mostValuableEmployee();
    public boolean remove(String groupName);
    public int remove(EmployeeGroup group);
    //public int countPartTimeEmployee();
    default int countPartTimeEmployee() {
        int countPartTimeEmployee = 0;
        for(EmployeeGroup employeeGroup : this) {
                countPartTimeEmployee+=employeeGroup.countPartTimeEmployee();
        }
        return countPartTimeEmployee;
    }
    default int countFullTimeEmployee(){
        int countFullTimeEmployee = 0;
        for(EmployeeGroup employeeGroup : this) {
            countFullTimeEmployee+=employeeGroup.countFullTimeEmployee();
        }
        return countFullTimeEmployee;
    }
    default int countEmployeeTraveller(){
        int countEmployeeTraveller = 0;
        for(EmployeeGroup employeeGroup : this) {
            countEmployeeTraveller += employeeGroup.countEmployeeTraveller();
        }
        return countEmployeeTraveller;
    }
    public Employee[] getEmployeeTraveller();
}
