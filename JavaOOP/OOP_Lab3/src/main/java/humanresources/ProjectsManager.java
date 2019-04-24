package humanresources;

import java.util.*;

public class ProjectsManager extends AbstractListNode<EmployeeGroup> implements GroupsManager, List<EmployeeGroup> {

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
    public boolean add(EmployeeGroup group)  {
        for(EmployeeGroup employeeGroup : this){
            if(employeeGroup.equals(group))
                try {
                    throw new AlreadyAddedException("This group already exists.");
                } catch (AlreadyAddedException e) {
                    e.printStackTrace();
                }
        }
        Node<EmployeeGroup> element = new Node<>();
        element.value = group;
        if (tail == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
        this.size++;
        return true;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups() {
        EmployeeGroup[] getEmployeesGroup = new EmployeeGroup[size];
        int countEmployeeGroup = 0;
        for(EmployeeGroup employeeGroup : this){
            getEmployeesGroup[countEmployeeGroup++] = employeeGroup;
        }
        return getEmployeesGroup;
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

    @Override
    public Iterator<EmployeeGroup> iterator() {
        return new Iterator<EmployeeGroup>() {
            Node<EmployeeGroup> t = head;

            @Override
            public boolean hasNext() {
                return t.next != null;
            }

            @Override
            public EmployeeGroup next() {
                if(hasNext()) {
                    t = t.next;
                    return t.value;
                }
                throw new NoSuchElementException("No element");
            }
        };
    }
}
