package humanresources;

public interface EmployeeGroup {

    public String getName();
    public void setName(String name);
    public void add(Employee employee);
    public Employee getEmployee(String firstName, String lastName);
    public boolean remove(String firstName, String lastName);
    public boolean remove(Employee employee);
    public Employee bestEmployee();
    public int employeeQuantity();
    public Employee[] getEmployees();
    public Employee[] employeesSortedBySalary();
    public int countPartTimeEmployee();
    public int countFullTimeEmployee();
    public int countEmployeeTraveller();
    public Employee[] getEmployeeTraveller();

}
