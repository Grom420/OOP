package humanresources;

import java.util.*;

public class Project extends AbstractListNode<Employee> implements EmployeeGroup, List<Employee> {

    private String name;

    public Project(){}

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Employee[] employees) throws AlreadyAddedException {
        this.name = name;
        Node node = new Node();
        for (Employee employee : employees) {
            add(employee);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee(String firstName, String lastName){
        for(Employee employee : this) {
            if(employee.getFirstName().equals(firstName) && employee.getSecondName().equals(lastName))
                return employee;
        }
        throw new NoSuchElementException();
    }

    public boolean remove(String firstName, String lastName){
        if (head == null) {
            return false;
        }


        if (head.value.getFirstName().equals(firstName) && head.value.getSecondName().equals(lastName))  {
            head = head.next;
            this.size--;
        }

        Node<Employee> currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.next.value.getFirstName().equals(firstName) && currentNode.next.value.getSecondName().equals(lastName)) {
                if (currentNode.next == tail) {
                    tail = currentNode;
                    currentNode.next = null;
                } else
                    currentNode.next = currentNode.next.next;
                this.size--;
            }
            currentNode = currentNode.next;
        }
        return false;

    }

    public Employee bestEmployee(){
        Node<Employee> t = head;
        Employee bestEmployee = t.value;
        for (int i = 0; i < size; i++) { //todo фор ич
            if(t.next.value.getSalary() > bestEmployee.getSalary()){
                bestEmployee = t.next.value;
            }
            t = t.next;
        }
        return bestEmployee;
    }

    public int employeeQuantity(){
        return this.size;
    }

    @Override
    public boolean hasEmployee(String firstName, String lastName) {
        for(Employee employee : this){
            if(employee.getFirstName().equals(firstName) && employee.getSecondName().equals(lastName))
                return true;
        }
        return false;
    }

    public static Employee[] sortBySalaryAndBonus(Employee[] arrEmp){
        Arrays.sort(arrEmp);
        return arrEmp;
    }

    public Employee[] getEmployees(){
        return new Employee[0];
    }

    public Employee[] employeesSortedBySalary() {
        Employee temp;
        Employee[] sortedEmployeesArray = getEmployees();
        Arrays.sort(sortedEmployeesArray /* todo,  comparator*/);
        return sortedEmployeesArray;
    }

    @Override
    public Employee[] getEmployeeTraveller() {
        Employee[] newEmployee = new Employee[size];
        int countEmployee = 0;
        for(Employee employee : this){
            if(employee.isTraveller())
                newEmployee[countEmployee++] = employee;
        }
        Employee[] getEmployeeTraveller = new Employee[countEmployee];
        System.arraycopy(getEmployeeTraveller, 0, newEmployee, 0, countEmployee);
        return getEmployeeTraveller;
    }

    private static void mergeSortSalaryEmployee(Employee[] employees) {
        if (employees.length > 1) {
            int leftPartLength = employees.length / 2;
            int rightPartLength = employees.length - leftPartLength;

            Employee[] leftArray = new Employee[leftPartLength];
            Employee[] rightArray = new Employee[rightPartLength];

            System.arraycopy(employees, 0, leftArray, 0, leftPartLength);
            System.arraycopy(employees, leftPartLength, rightArray, 0, rightPartLength);

            mergeSortSalaryEmployee(leftArray);
            mergeSortSalaryEmployee(rightArray);

            int leftArrayIndex = 0;
            int rightArrayIndex = 0;
            int targetIndex = 0;

            while (targetIndex < employees.length) {
                if (leftArrayIndex >= leftArray.length) {
                    employees[targetIndex] = rightArray[rightArrayIndex];
                    rightArrayIndex++;
                } else if (rightArrayIndex >= rightArray.length) {
                    employees[targetIndex] = leftArray[leftArrayIndex];
                    leftArrayIndex++;
                } else if (leftArray[leftArrayIndex].getSalary() >= rightArray[rightArrayIndex].getSalary()) {
                    employees[targetIndex] = leftArray[leftArrayIndex];
                    leftArrayIndex++;
                } else {
                    employees[targetIndex] = rightArray[rightArrayIndex];
                    rightArrayIndex++;
                }
                targetIndex++;
            }
        }
    }

    @Override
    public String toString() {
        //todo no array and use foreach
        Employee[] employees = getEmployees();
        final StringBuilder sb = new StringBuilder("Project ");
        sb.append(name).append(":").append(size).append("\n");
        if (employees != null)
            for (int i = 0; i < size; i++) {
                sb.append('<').append(employees[i]).append(">\n");
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return employeeQuantity() == project.employeeQuantity() &&
                getName().equals(project.getName());
    }

    @Override
    public int hashCode() {
        //todo no array and use foreach
        Employee[] employees = getEmployees();
        int hcObj = Objects.hashCode(employees[0]);
        int hcPos = Objects.hashCode(0);
        for (int i = 1; i < employees.length; i++) {
            hcObj ^= Objects.hashCode(employees[i]);
            hcPos ^= i;
        }
        return hcObj ^ hcPos;
    }
}
