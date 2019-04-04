package humanresources;

import java.util.Iterator;

public class DepartamentsManager implements GroupsManager {
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

        if (groups.length != 0) {
            EmployeeGroup[] newEmployees = new EmployeeGroup[groups.length];
            System.arraycopy(groups, 0, newEmployees, 0, groups.length);
            this.groups = newEmployees;
        }
        else{
            throw new NegativeSizeException("Negative capacity");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(EmployeeGroup employeeGroup) throws AlreadyAddedException {
        if (groupsSize == groups.length) {
            EmployeeGroup[] newEmployees;
            newEmployees = new EmployeeGroup[this.groups.length * 2];
            System.arraycopy(this.groups, 0, newEmployees, 0, this.groups.length);
            this.groups = newEmployees;
        }
        for (int i = 0; i < size; i++) {
            if(employeeGroup.equals(groups[i]))
                throw new AlreadyAddedException("Already added");
        }
        this.groups[this.groupsSize] = employeeGroup;
        this.groupsSize++;
    }

    public int groupsQuantity() {
        return groupsSize;
    }

    public EmployeeGroup getEmployeeGroup(String name){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].getName().equals(name))
                return groups[i];
        }
        return null;
    }

    public EmployeeGroup[] getEmployeesGroups(){

        EmployeeGroup[] newGroups = new EmployeeGroup[this.groups.length];
        System.arraycopy(groups, 0, newGroups, 0, groups.length);
        return newGroups;
    }



    public boolean remove(String groupName){

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

    public EmployeeGroup[] getEmployeeGroups() {
        EmployeeGroup[] newGroups = new EmployeeGroup[this.groups.length];
        System.arraycopy(groups, 0, newGroups, 0, groups.length);
        return newGroups;
    }

    public int size() {
        return size;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += groups[i].employeeQuantity();
        }
        return employeesQuantity;
    }

    public EmployeeGroup getEmployeeGroup(String firstName, String secondName){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].getEmployee(firstName, secondName) != null){
                return groups[i];
            }
        }
        return null;
    }

    public Employee mostValuableEmployee() {
        Employee bestEmployee = groups[0].bestEmployee();
        for (int i = 1; i < size; i++) {
            if(bestEmployee.getSalary() < groups[i].bestEmployee().getSalary())
                bestEmployee = groups[i].bestEmployee();
        }
        return bestEmployee;
    }

    public int remove(EmployeeGroup employeeGroup){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].equals(employeeGroup)) {
                shiftGroups(i);
                countDeletedGroup++;
            }
        }
        return countDeletedGroup;
    }

    @Override
    public int countPartTimeEmployee() {
        int countPartTimeEmployee = 0;
        for (int i = 0; i < size; i++) {
            countPartTimeEmployee+=groups[i].countPartTimeEmployee();
        }
        return countPartTimeEmployee;
    }

    @Override
    public int countFullTimeEmployee() {
        int countFullTimeEmployee = 0;
        for (int i = 0; i < size; i++) {
            countFullTimeEmployee+=groups[i].countFullTimeEmployee();
        }
        return countFullTimeEmployee;
    }

    @Override
    public int countEmployeeTraveller() {
        int countEmployeeTraveller = 0;
        for (int i = 0; i < size; i++) {
            countEmployeeTraveller+=groups[i].countEmployeeTraveller();
        }
        return countEmployeeTraveller;
    }

    @Override
    public Employee[] getEmployeeTraveller() {
        return new Employee[0];
    }


    private void shiftGroups(int i){
        System.arraycopy(this.groups, i + 1, this.groups, i, groupsSize - i);
    }

    @Override
    public Iterator<EmployeeGroup> iterator() {
        //todo реализацию итератора в студию
        return null;
    }
}
