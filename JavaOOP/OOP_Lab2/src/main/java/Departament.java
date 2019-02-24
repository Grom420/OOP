public class Departament {

    private final int DEFAULT_SIZE = 8;
    private String name;
    private Employee[] employees;
    private int size;

    public Departament(String name) {
        this.name = name;
        this.employees = new Employee[DEFAULT_SIZE];
    }

    public Departament(String name, int size) {
        this.name = name;
        employees = new Employee[size];
        this.size = 0;
    }

    public Departament(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public void add(Employee employee){

        Employee[] newEmployees = new Employee[this.employees.length*2];
        System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
        newEmployees[this.size] = employee;
        this.employees = newEmployees;
        this.size++;
    }

    public boolean remove(String firstName, String secondName){

        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName)){
                shift(i);
                return true;
            }
        }
        return false;
    }

    public int size(){

        int count = 0;
        for (int i = 0; i < this.size; i++) {
            count++;
        }
        return count;
    }

    private void shift(int i){

        System.arraycopy(this.employees, i+1, this.employees, i, size-i);
        this.employees[size] = null;
        this.size--;
    }

    public Employee[] getEmployees(){

        Employee[] newEmployee = new Employee[this.size];
        System.arraycopy(this.employees, 0, newEmployee, 0, this.size);
        return newEmployee;
    }

    public Employee[] getEmployees(String jobTitle){

        Employee[] newEmployee = new Employee[this.size];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if(employees[i].getJobTitle().equals(jobTitle)){
                newEmployee[count] = employees[i];
                count++;
            }
        }
        System.arraycopy(newEmployee, 0, newEmployee, 0, count);
        return newEmployee;
    }

    public Employee[] employeesSortedBySalary(){

        return null;
    }
}
