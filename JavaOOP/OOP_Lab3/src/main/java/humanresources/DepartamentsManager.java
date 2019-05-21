package humanresources;

import java.io.Serializable;
import java.util.*;

public class DepartamentsManager extends AbstractListArray<EmployeeGroup> implements GroupsManager, List<EmployeeGroup>, Serializable {
    private EmployeeGroup[] groups;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private int groupsSize;
    private int countDeletedGroup;

    public DepartamentsManager(String groupsName) {
        this(groupsName, new EmployeeGroup[DEFAULT_CAPACITY]);
    }

    public DepartamentsManager(String groupsName, EmployeeGroup[] groups) {

        if (groups.length == 0)
            throw new NegativeSizeException("Negative capacity");
        EmployeeGroup[] newEmployees = new EmployeeGroup[groups.length];
        System.arraycopy(groups, 0, newEmployees, 0, groups.length);
        this.groups = newEmployees;
    }

    public boolean add(EmployeeGroup employeeGroup) {
        return super.add(employeeGroup);
    }

    public boolean remove(Object o){
        return super.remove(o);
    }

    public boolean addAll(Collection<? extends EmployeeGroup> c){
        return super.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends EmployeeGroup> c){
        return super.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c){
        return super.removeAll(c);
    }

    public boolean retainAll(Collection<?> c){
        return super.retainAll(c);
    }

    public void clear(){
        super.clear();
    }

    public void add(int index, EmployeeGroup element){
        super.add(index, element);
    }

    public EmployeeGroup remove(int index){
        return super.remove(index);
    }

    public int groupsQuantity() {
        return groupsSize;
    }

    public EmployeeGroup[] getEmployeesGroups() {

        EmployeeGroup[] newGroups = new EmployeeGroup[this.groups.length];
        System.arraycopy(groups, 0, newGroups, 0, groups.length);
        return newGroups;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += groups[i].employeeQuantity();
        }
        return employeesQuantity;
    }

    public boolean remove(String groupName) {

        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(groupName)) {
                shiftGroups(i);
                this.groups[groupsQuantity()] = null;
                this.size--;
                return true;
            }
        }
        return false;
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
