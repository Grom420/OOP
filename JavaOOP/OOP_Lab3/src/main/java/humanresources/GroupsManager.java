package humanresources;

import java.util.List;

public interface GroupsManager extends Iterable<EmployeeGroup>, List<EmployeeGroup> {

    public int employeesQuantity();
    public int groupsQuantity();
    public void add(int index, EmployeeGroup group);
    public boolean add(EmployeeGroup group);
    default EmployeeGroup getEmployeeGroup(String name){
        for (EmployeeGroup employeeGroup : this) {
            if (employeeGroup.getName().equals(name))
                return employeeGroup;
        }
        return null;
    }
    public EmployeeGroup[] getEmployeesGroups();
    default int employeesQuantity(JobTitilesEnum jobTitle) {
            int employeesQuantity = 0;
            for (EmployeeGroup group : this) {
                employeesQuantity += group.employeesQuantity(jobTitle);
            }
            return employeesQuantity;
    }
    default EmployeeGroup getEmployeeGroup(String firstName, String secondName){
        for(EmployeeGroup employeeGroup : this) {
            if(employeeGroup.hasEmployee(firstName, secondName))
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
