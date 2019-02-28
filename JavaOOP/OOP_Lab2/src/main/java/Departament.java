public class Departament {

    private final int DEFAULT_SIZE = 8;
    private String name;
    private Employee[] employees;
    private int size;

    //todo конструкторы должны вызывать друг друга
    public Departament(String name) {
        this.name = name; //todo эта строчка дублируется во всех конструкторах - юзай метод setName()
        this.employees = new Employee[DEFAULT_SIZE];
    }
    //todo capacity
    public Departament(String name, int size) {
        //todo check capacity
        this.name = name;
        employees = new Employee[size];
        this.size = 0;
    }

    //todo создавай свой массив и копируй элементы в него
    public Departament(String name, Employee[] employees) {
        //todo check length
        this.name = name;
        this.employees = employees; //todo copy elements
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Employee employee){
        //todo if(size == length)
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
return size;
    }

    //todo имя метода не соответсвует
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
        //todo new array [count]
        System.arraycopy(newEmployee, 0, newEmployee, 0, count);
        return newEmployee;
    }

    public Employee[] employeesSortedBySalary(){

        return null;
    }
}
