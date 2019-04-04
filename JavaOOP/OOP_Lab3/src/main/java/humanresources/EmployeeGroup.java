package humanresources;

public interface EmployeeGroup extends Iterable<Employee> {

    public String getName();
    public void setName(String name);
    public void add(Employee employee) throws AlreadyAddedException;
    public Employee getEmployee(String firstName, String lastName);
    public boolean remove(String firstName, String lastName);
    public boolean remove(Employee employee);
    public Employee bestEmployee();
    public int employeeQuantity();
    int employeesQuantity(JobTitilesEnum jobTitile);
    public Employee[] getEmployees();
    public Employee[] employeesSortedBySalary();
    public int countPartTimeEmployee();
    public int countFullTimeEmployee();
    public int countEmployeeTraveller();
    public Employee[] getEmployeeTraveller();

}
