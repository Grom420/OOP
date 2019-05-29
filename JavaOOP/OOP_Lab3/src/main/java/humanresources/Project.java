package humanresources;

import java.io.Serializable;
import java.util.*;

public class Project extends AbstractListNode<Employee> implements EmployeeGroup, List<Employee>, Comparator<Employee>, Serializable {

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

    public boolean add(Employee employee) {
        return super.add(employee);
    }

    public boolean remove(Object o){
        return super.remove(o);
    }

    public boolean addAll(Collection<? extends Employee> c){
        return super.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Employee> c){
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

    public Employee set(int index, Employee element){
        return super.set(index, element);
    }

    public void add(int index, Employee element){
        super.add(index, element);
    }

    public Employee remove(int index){
        return super.remove(index);
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

    public Employee[] sortBySalaryAndBonus(Employee[] arrEmp){
        Arrays.sort(arrEmp);
        return arrEmp;
    }

    public Employee[] getEmployees(){
        return new Employee[0];
    }

    public Employee[] employeesSortedBySalary() {
        Employee[] sortedEmployeesArray = getEmployees();
        Arrays.sort(sortedEmployeesArray, this::compare);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project ");
        sb.append(name).append(":").append(size).append("\n");
        for (Employee employee : this) {
            sb.append('<').append(employee).append(">\n");
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Class) return false;
        Project project = (Project) o;
        return employeeQuantity() == project.employeeQuantity() &&
                getName().equals(project.getName());
    }

    @Override
    public int hashCode() {
        int hashObject = 0;
        int hashPosition = 0;
        int i = 0;
        for (Employee employee : this) {
            hashObject ^= Objects.hashCode(employee);
            hashPosition ^= i++;
        }
        return hashObject ^ hashPosition;
    }
}
