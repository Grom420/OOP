package humanresources;

import java.util.*;

public class DepartamentsManager extends AbstractListArray<EmployeeGroup> implements GroupsManager, List<EmployeeGroup> {
    private String name;
    private EmployeeGroup[] groups;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private int groupsSize;
    private int countDeletedGroup;

    public DepartamentsManager(String name, String groupsName) {
        this(name, groupsName, new Employee[DEFAULT_CAPACITY]);
    }

    public DepartamentsManager(String name, String groupsName, Employee[] groups) {

        if (groups.length == 0)
            throw new NegativeSizeException("Negative capacity");
        EmployeeGroup[] newEmployees = new EmployeeGroup[groups.length];
        System.arraycopy(groups, 0, newEmployees, 0, groups.length);
        this.groups = newEmployees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int groupsQuantity() {
        return groupsSize;
    }

    public EmployeeGroup[] getEmployeesGroups() {

        EmployeeGroup[] newGroups = new EmployeeGroup[this.groups.length];
        System.arraycopy(groups, 0, newGroups, 0, groups.length);
        return newGroups;
    }

    public boolean remove(String groupName) {

        for (int i = 0; i < groups.length; i++) {
            if (groups[i].getName().equals(groupName)) {
                shiftGroups(i);
                this.groups[groupsQuantity()] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += groups[i].employeeQuantity();
        }
        return employeesQuantity;
    }

    public Employee mostValuableEmployee() {
        Employee bestEmployee = groups[0].bestEmployee();
        for (int i = 1; i < size; i++) {
            if (bestEmployee.getSalary() < groups[i].bestEmployee().getSalary())
                bestEmployee = groups[i].bestEmployee();
        }
        return bestEmployee;
    }

    public int remove(EmployeeGroup employeeGroup) {
        for (int i = 0; i < groupsQuantity(); i++) {
            if (groups[i].equals(employeeGroup)) {
                shiftGroups(i);
                countDeletedGroup++;
            }
        }
        return countDeletedGroup;
    }

    @Override
    public Employee[] getEmployeeTraveller() {
        Employee[] newEmployee = new Employee[size];
        int countEmployeeTraveller = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < groups[i].getEmployeeTraveller().length; j++) {
                newEmployee[countEmployeeTraveller++] = groups[i].getEmployeeTraveller()[j];
            }
        }
        System.arraycopy(newEmployee, 0, newEmployee, 0, countEmployeeTraveller);
        return newEmployee;
    }


    private void shiftGroups(int i) {
        System.arraycopy(this.groups, i + 1, this.groups, i, groupsSize - i);
    }
}
