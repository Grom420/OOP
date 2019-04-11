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
    public boolean hasEmployee(String firstName, String lastName);
    default int employeesQuantity(JobTitilesEnum jobTitile){
        int employeesQuantity = 0;
        for(Employee employee : this){
            if(employee.getJobTitle().equals(jobTitile))
                employeesQuantity++;
        }
        return employeesQuantity;
    }
    public Employee[] getEmployees();
    public Employee[] employeesSortedBySalary();
    default int countPartTimeEmployee(){
        int countPartTimeEmployee = 0;
        for(Employee employee : this){
            if(employee.isPartTimer())
                countPartTimeEmployee++;
        }
        return countPartTimeEmployee;
    }
    default int countFullTimeEmployee(){
        int countFullTimeEmployee = 0;
        for(Employee employee : this){
            if(!employee.isPartTimer())
                countFullTimeEmployee++;
        }
        return countFullTimeEmployee;
    }
    default int countEmployeeTraveller(){
        int countEmployeeTraveller = 0;
        for(Employee employee : this){
            if(employee.isTraveller())
                countEmployeeTraveller++;
        }
        return countEmployeeTraveller;
    }
    public Employee[] getEmployeeTraveller();

}
