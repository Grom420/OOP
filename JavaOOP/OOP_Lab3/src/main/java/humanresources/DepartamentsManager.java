package humanresources;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        for(EmployeeGroup group : this){
            if(group.equals(employeeGroup))
                throw new AlreadyAddedException("This group already exists.");
        }
        if (groupsSize == groups.length) {
            EmployeeGroup[] newEmployees;
            newEmployees = new EmployeeGroup[this.groups.length * 2];
            System.arraycopy(this.groups, 0, newEmployees, 0, this.groups.length);
            this.groups = newEmployees;
        }
        this.groups[this.groupsSize] = employeeGroup;
        this.groupsSize++;
    }

    public int groupsQuantity() {
        return groupsSize;
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
    public Employee[] getEmployeeTraveller() {
        Employee[] newEmployee = new Employee[size];
        int countEmployeeTraveller = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < groups[i].getEmployeeTraveller().length; j++) {
                if(groups[i].getEmployeeTraveller()[j].isTraveller())
                    newEmployee[countEmployeeTraveller++] = newEmployee[i];
            }
        }
        System.arraycopy(newEmployee, 0, newEmployee, 0, countEmployeeTraveller);
        return newEmployee;
    }


    private void shiftGroups(int i){
        System.arraycopy(this.groups, i + 1, this.groups, i, groupsSize - i);
    }

    @Override
    public Iterator<EmployeeGroup> iterator() {
        //todo реализацию итератора в студию(DONE)
        return new Iterator<EmployeeGroup>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public EmployeeGroup next() {
                if(hasNext()) {
                    return groups[currentIndex++];
                }
                throw new NoSuchElementException("No element");
            }
        };
    }
}
