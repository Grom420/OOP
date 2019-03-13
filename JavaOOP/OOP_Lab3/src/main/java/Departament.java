import java.util.Arrays;

public class Departament {

    private final int DEFAULT_CAPACITY = 8;
    private String name;
    private Employee[] employees;
    private int size;

    //todo конструкторы должны вызывать друг друга
    public Departament(){
        this("");
    }
    //todo логично инициировать массив в методе
    public Departament(String name) {

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
            Employee[] newEmployees = new Employee[employees.length];//todo имя - отстой(DONE)
            System.arraycopy(employees, 0, newEmployees, 0, employees.length);
            this.employees = newEmployees;
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
        int employeeQuantity = 0; //todo employeesQuantity(DONE)
        for (int i = 0; i < size; i++) {
            assert false;
            if (employee.getJobTitle().equals(jobTitle))
                employeeQuantity++;
        }
        return employeeQuantity;
    }

    public Employee bestEmployee(){

        Employee bestEmployee = employees[0]; //todo bestEmployee(DONE)
        int total = 0;

        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];

            if (employee.getSalary() > total) {

                total = employees[i].getSalary();
                bestEmployee = employees[i];
            }
        }

        return bestEmployee;
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
        Employee[] newJobTitleEmployees = new Employee[count]; //todo никаких цифр для дифференциации имен(DONE)
        System.arraycopy(newEmployee, 0, newJobTitleEmployees, 0, count);
        return newJobTitleEmployees;
    }

    public Employee[] empoyessSortedBySalary(){

        return sortMerge(this.employees);
    }

    private static Employee[] sortMerge(Employee[] arrEmployees) {
        if (arrEmployees.length < 2) return arrEmployees;
        int middle = arrEmployees.length / 2;
        return merge(sortMerge(Arrays.copyOfRange(arrEmployees, 0, middle)),
                sortMerge(Arrays.copyOfRange(arrEmployees, middle, arrEmployees.length)));
    }

    private static Employee[] merge(Employee[] arrEmployeesOne, Employee[] arrEmployeesTwo) {
        int len_1 = arrEmployeesOne.length, len_2 = arrEmployeesTwo.length;
        int countArrOne = 0, countArrTwo = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        Employee[] result = new Employee[len];
        for (int i = 0; i < len; i++) {
            if (countArrTwo < len_2 && countArrOne < len_1) {
                if (arrEmployeesOne[countArrOne].getSalary() > arrEmployeesTwo[countArrTwo].getSalary()) {
                    countArrTwo++;
                    result[i].setSalary(arrEmployeesTwo[countArrTwo].getSalary());
                    result[i].setJobTitle(arrEmployeesTwo[countArrTwo].getJobTitle());
                    result[i].setFirstName(arrEmployeesTwo[countArrTwo].getFirstName());
                    result[i].setSecondName(arrEmployeesTwo[countArrTwo].getSecondName());
                } else {
                    countArrOne++;
                    result[i].setSalary(arrEmployeesOne[countArrOne].getSalary());
                    result[i].setJobTitle(arrEmployeesOne[countArrOne].getJobTitle());
                    result[i].setFirstName(arrEmployeesOne[countArrOne].getFirstName());
                    result[i].setSecondName(arrEmployeesOne[countArrOne].getSecondName());
                }
            } else if (countArrTwo < len_2) {
                countArrTwo++;
                result[i].setSalary(arrEmployeesTwo[countArrTwo].getSalary());
                result[i].setJobTitle(arrEmployeesTwo[countArrTwo].getJobTitle());
                result[i].setFirstName(arrEmployeesTwo[countArrTwo].getFirstName());
                result[i].setSecondName(arrEmployeesTwo[countArrTwo].getSecondName());
            } else {
                countArrOne++;
                result[i].setSalary(arrEmployeesOne[countArrOne].getSalary());
                result[i].setJobTitle(arrEmployeesOne[countArrOne].getJobTitle());
                result[i].setFirstName(arrEmployeesOne[countArrOne].getFirstName());
                result[i].setSecondName(arrEmployeesOne[countArrOne].getSecondName());
            }
        }
        return result;
    }
}
