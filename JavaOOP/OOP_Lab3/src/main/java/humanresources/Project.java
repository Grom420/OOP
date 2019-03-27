package humanresources;

import java.util.Objects;

public class Project implements EmployeeGroup {

    private String name;
    private int size;
    private Node head;
    private Node tail;

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Employee[] employees){
        this.name = name;
        Node node = new Node();
        for (int i = 0; i < employees.length; i++) {
            add(employees[i]);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Employee employee) {
        Node a = new Node();
        a.value = employee;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    public Employee getEmployee(String firstName, String lastName){

        if (head == null) {
            return null;
        }

        if (head.value.getFirstName().equals(firstName) && head.value.getSecondName().equals(lastName))  {
            return head.value;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.value.getFirstName().equals(firstName) && t.next.value.getSecondName().equals(lastName)) {
                if (tail.value.getFirstName().equals(t.next.value.getFirstName())
                        && tail.value.getSecondName().equals(t.next.value.getSecondName())) {
                    tail = t;
                }
                return t.next.value;
            }
            t = t.next;
        }
        return null;
    }

    public void removeEmployee(String firstName, String lastName){

        if (head == null) {
            return;
        }


        if (head.value.getFirstName().equals(firstName) && head.value.getSecondName().equals(lastName))  {
            head = head.next;
            this.size--;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.value.getFirstName().equals(firstName) && t.next.value.getSecondName().equals(lastName)) {
                if (tail.value.getFirstName().equals(t.next.value.getFirstName())
                        && tail.value.getSecondName().equals(t.next.value.getSecondName())) {
                    tail = t;
                }
                t.next = t.next.next;
                this.size--;
            }
            t = t.next;
        }
    }

    public void remove(Employee employee){

        if (head == null) {
            return;
        }


        if (head.value.equals(employee))  {
            head = head.next;
            this.size--;
        }

        Node t = head;
        while (t.next != null) {
            if (t.next.value.equals(employee)) {
                if (tail.value.equals(t.next.value)) {
                    tail = t;
                }
                t.next = t.next.next;
                this.size--;
            }
            t = t.next;
        }
    }

    public Employee bestEmployee(){

        Node t = head;
        Employee bestEmployee = t.value;
        for (int i = 0; i < size; i++) {
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

    public Employee[] getEmployees(){
        Employee[] employees = new Employee[size];
        Node t = head;
        for (int i = 0; i < size; i++) {
            employees[i] = t.value;
            t = t.next;
        }
        return employees;
    }

    public Employee[] employeesSortedBySalary() {
        Employee temp;
        Employee[] sortedEmployeesArray = getEmployees();

        mergeSortSalaryEmployee(sortedEmployeesArray);

        for (int i = 0; i < this.size; i++) {
            temp = sortedEmployeesArray[i];
            sortedEmployeesArray[i] = sortedEmployeesArray[sortedEmployeesArray.length - i - 1];
            sortedEmployeesArray[sortedEmployeesArray.length - i - 1] = temp;
        }
        return sortedEmployeesArray;
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
        Employee[] employees = getEmployees();
        final StringBuffer sb = new StringBuffer("Project ");
        sb.append(name).append(":").append(size).append("\n");
        if (employees == null) {
            sb.append("employee=").append(" null\n");
        } else for (int i = 0; i < size; i++) {
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
