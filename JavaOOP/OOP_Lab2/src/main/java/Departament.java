public class Departament {

    private final int DEFAULT_CAPACITY = 8;
    private String name;
    private Employee[] employees;
    private int size;

    //todo конструкторы должны вызывать друг друга
    public Departament(){}

    //todo логично инициировать массив в методе
    public Departament(String name) {
        setName(name);
        this.employees = new Employee[DEFAULT_CAPACITY];
    }

    //todo capacity(DONE)
    public Departament(String name, int capacity) {
        this(name);
        if (capacity > 0) {
            employees = new Employee[capacity];
            this.size = 0;
        } else {
            this.employees = new Employee[DEFAULT_CAPACITY];
        }
    }

    //todo создавай свой массив и копируй элементы в него(DONE)
    public Departament(String name, Employee[] employees) {
        this(name);
        if(employees.length > 0) {
            Employee[] bufEmp = new Employee[employees.length];//todo имя - отстой
            System.arraycopy(employees, 0, bufEmp, 0, employees.length);
            this.employees = bufEmp;
        } else {
            this.employees = new Employee[DEFAULT_CAPACITY];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int employeesQuantity(String jobTitle){

        Employee employee = new Employee();
        int count = 0; //todo employeesQuantity
        for (int i = 0; i < size; i++) {
            assert false;
            if (employee.getJobTitle().equals(jobTitle))
                count++;
        }
        return count;
    }

    public Employee bestEmployee(){

        Employee bestEmp = employees[0]; //todo bestEmployee
        int total = 0;

        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];

            if (employee.getSalary() > total) {

                total = employees[i].getSalary();
                bestEmp = employees[i];
            }
        }

        return bestEmp;
    }

    public boolean hasEmployee(String firstName, String lastName){


        for (int i = 0; i < size; i++) {

            Employee employee = employees[i];
            if (employee.getFirstName().equals(firstName) && employee.getSecondName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public void add(Employee employee) {
        if (size == employees.length) {
            Employee[] newEmployees;
            newEmployees = new Employee[this.employees.length * 2];
            System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
            this.employees = newEmployees;
        }
        this.employees[this.size] = employee;
        this.size++;
    }

    public boolean remove(String firstName, String secondName) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName)) {
                shift(i);
                this.employees[size] = null;
                this.size--;
                return true;
            }
        }
        return false;
    }

    public int size() {

        return size;
    }

    private void shift(int i) {

        System.arraycopy(this.employees, i + 1, this.employees, i, size - i);
    }

    public Employee[] getEmployees() {

        Employee[] newEmployee = new Employee[this.size];
        System.arraycopy(this.employees, 0, newEmployee, 0, this.size);
        return newEmployee;
    }

    public Employee[] getEmployees(String jobTitle) {

        Employee[] newEmployee = new Employee[this.size];
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (employees[i].getJobTitle().equals(jobTitle)) {
                newEmployee[count] = employees[i];
                count++;
            }
        }
        Employee[] newEmployee2 = new Employee[count]; //todo никаких цифр для дифференциации имен
        System.arraycopy(newEmployee, 0, newEmployee2, 0, count);
        return newEmployee2;
    }

    public Employee[] employeesSortedBySalary() {
        //todo ГИДЕ СОРТИРОВКААААА.....
        return null;
    }
}
