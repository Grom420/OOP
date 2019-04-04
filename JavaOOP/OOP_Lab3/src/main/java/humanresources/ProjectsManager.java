package humanresources;

import java.util.Iterator;

public class ProjectsManager extends List<EmployeeGroup> implements GroupsManager {

    private Node<EmployeeGroup> head;
    private Node<EmployeeGroup> tail;
    private int size;

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
        return getSize();
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String name) {

        if (head == null) {
            return null;
        }

        if (head.value.getName().equals(name))  {
            return head.value;
        }

        //todo благодаря итератору можно делать так(DONE)
        for (EmployeeGroup employeeGroup : this) {
            if (employeeGroup.getName().equals(name))
                return employeeGroup;
        }

        return null;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups() {
        return toArray();
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String firstName, String secondName) {
        if (head == null) {
            return null;
        }

        if (head.value.getEmployee(firstName, secondName) != null)  {
            return head.value;
        }

        for(EmployeeGroup employeeGroup : this) {
            if(employeeGroup.getEmployee(firstName, secondName) != null)
                return employeeGroup;
        }

        return null;
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

        Node<EmployeeGroup> currentT = head;
        while (currentT.next != null) {
            if (currentT.next.value.getName().equals(groupName)) {
                if (currentT.next == tail) {
                    tail = currentT;
                    currentT.next = null;
                } else
                    currentT.next = currentT.next.next;
                this.size--;
            }
            currentT = currentT.next;
        }
        return false;
    }

    @Override
    public int remove(EmployeeGroup group) {
        return 0;
    }

    @Override
    public int countPartTimeEmployee() {
        if (head == null) {
            return 0;
        }

        int countPartTimeEmployee = 0;

        for(EmployeeGroup employeeGroup : this) {
                countPartTimeEmployee+=employeeGroup.countPartTimeEmployee();
        }

        return countPartTimeEmployee;
    }

    @Override
    public int countFullTimeEmployee() {
        if (head == null) {
            return 0;
        }

        int countFullTimeEmployee = 0;

        for(EmployeeGroup employeeGroup : this) {
            countFullTimeEmployee+=employeeGroup.countFullTimeEmployee();
        }

        return countFullTimeEmployee;
    }

    @Override
    public int countEmployeeTraveller() {
        if (head == null) {
            return 0;
        }

        int countEmployeeTraveller = 0;

        for(EmployeeGroup employeeGroup : this) {
            countEmployeeTraveller+=employeeGroup.countEmployeeTraveller();
        }

        return countEmployeeTraveller;
    }

    @Override
    public Employee[] getEmployeeTraveller() {
        return new Employee[0];
    }
}
