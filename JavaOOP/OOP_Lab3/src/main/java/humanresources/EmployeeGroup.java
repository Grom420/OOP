package humanresources;

public interface EmployeeGroup {

    public String getName();
    public void setName(String name);
    public void add(Employee employee);
    public Employee getEmployee(String firstName, String lastName);
    public void removeEmployee(String firstName, String lastName);
    public void remove(Employee employee);
    public Employee bestEmployee();
    public int employeeQuantity();
    public Employee[] getEmployees();
    public Employee[] employeesSortedBySalary();

}
