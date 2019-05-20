package humanresources;

import java.io.Serializable;
import java.util.*;

public class ProjectsManager extends AbstractListNode<EmployeeGroup> implements GroupsManager, List<EmployeeGroup>, Serializable {

    private Node<EmployeeGroup> head;
    private Node<EmployeeGroup> tail;
    private int size;
    private int countRemove;

    public ProjectsManager(){}

    public ProjectsManager(EmployeeGroup[] employeeGroups) throws AlreadyAddedException {
        for (int i = 0; i < employeeGroups.length; i++) {
            add(employeeGroups[i]);
        }
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

    public EmployeeGroup set(int index, EmployeeGroup element){
        return super.set(index, element);
    }

    public void add(int index, EmployeeGroup element){
        super.add(index, element);
    }

    public EmployeeGroup remove(int index){
        return super.remove(index);
    }

    @Override
    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (EmployeeGroup employeeGroup : this) {
            employeesQuantity += employeeGroup.employeeQuantity();
        }
        return employeesQuantity;
    }

    @Override
    public int groupsQuantity() {
        return size;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups() {
        return new EmployeeGroup[0];
    }

    @Override
    public Employee mostValuableEmployee() {
        Employee mostValuableEmployee = head.value.bestEmployee();
        for(EmployeeGroup employeeGroup : this) {
            if(employeeGroup.bestEmployee().getSalary() > mostValuableEmployee.getSalary())
                mostValuableEmployee = employeeGroup.bestEmployee();
        }
        return mostValuableEmployee;
    }

    @Override
    public boolean remove(String groupName) {
        if (head == null) {
            return false;
        }


        if (head.value.getName().equals(groupName))  {
            head = head.next;
            this.size--;
            return true;
        }

        Node<EmployeeGroup> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value.getName().equals(groupName)) {
                if (currentNode.next == tail) {
                    tail = currentNode;
                    currentNode.next = null;
                } else
                    currentNode.next = currentNode.next.next;
                this.size--;
            }
            currentNode = currentNode.next;
            this.countRemove++;
        }
        return false;
    }

    @Override
    public int remove(EmployeeGroup group) {
        return this.countRemove;
    }

    @Override
    public Employee[] getEmployeeTraveller() {
        Employee[] getEmployeeTraveller = new Employee[size];
        int countEmployeeTraveller = 0;
        for(EmployeeGroup employeeGroup : this){
                getEmployeeTraveller[countEmployeeTraveller] = employeeGroup.getEmployeeTraveller()[countEmployeeTraveller];
                countEmployeeTraveller++;
        }
        return getEmployeeTraveller;
    }
}
