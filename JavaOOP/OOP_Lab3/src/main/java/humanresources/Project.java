package humanresources;

import java.util.*;

public class Project implements EmployeeGroup {

    private String name;
    private int size;
    private Node<Employee> head;
    private Node<Employee> tail;

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

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public Employee getEmployee(String firstName, String lastName){

        if (head == null) {
            return null;
        }
        if (head.value.getFirstName().equals(firstName) && head.value.getSecondName().equals(lastName))  {
            return head.value;
        }
        for(Employee employee : this) {
            if(employee.getFirstName().equals(firstName) && employee.getSecondName().equals(lastName))
                return employee;
        }

        return null;
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

    public boolean remove(Employee employee){

        if (head == null) {
            return false;
        }


        if (head.value.equals(employee))  {
            head = head.next;
            this.size--;
        }

        Node<Employee> currentT = head;
        while (currentT.next != null) {
            if (currentT.next.value.equals(employee)) {
                if (tail.value.equals(currentT.next.value)) {
                    tail = currentT;
                }
                currentT.next = currentT.next.next;
                this.size--;
            }
            currentT = currentT.next;
        }
        return false;
    }

    public Employee bestEmployee(){

        Node<Employee> t = head;
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

        mergeSortSalaryEmployee(sortedEmployeesArray);

        for (int i = 0; i < this.size; i++) {
            temp = sortedEmployeesArray[i];
            sortedEmployeesArray[i] = sortedEmployeesArray[sortedEmployeesArray.length - i - 1];
            sortedEmployeesArray[sortedEmployeesArray.length - i - 1] = temp;
        }
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
        Employee[] employees = getEmployees();
        int hcObj = Objects.hashCode(employees[0]);
        int hcPos = Objects.hashCode(0);
        for (int i = 1; i < employees.length; i++) {
            hcObj ^= Objects.hashCode(employees[i]);
            hcPos ^= i;
        }
        return hcObj ^ hcPos;
    }

    @Override
    public Employee get(int index) {
        return null;
    }

    @Override
    public Employee set(int index, Employee element) {
        return null;
    }

    @Override
    public void add(int index, Employee element) {

    }

    @Override
    public Employee remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Employee> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Employee> listIterator(int index) {
        return null;
    }

    @Override
    public List<Employee> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            Node<Employee> t = head;

            @Override
            public boolean hasNext() {
                return t.next != null;
            }

            @Override
            public Employee next() {
                if(hasNext()) {
                    t = t.next;
                    return head.value;
                }
                throw new NoSuchElementException("No element");
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Employee employee) {
        return false;
    }
}
