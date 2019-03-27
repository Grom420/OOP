package humanresources;

public class DepartamentsManager implements EmployeeGroup {

    private String name;
    private Departament[] departaments;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;


    public DepartamentsManager(String name) {
        this(name, new Departament[DEFAULT_CAPACITY]);
    }

    public DepartamentsManager(String name, Departament[] departaments) {

        if (departaments.length != 0) {
            Departament[] newDepartamets = new Departament[departaments.length]; //todo имя гавно(DONE)
            System.arraycopy(departaments, 0, newDepartamets, 0, departaments.length);
            this.departaments = newDepartamets;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Employee employee) {
        
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {

    }

    @Override
    public void remove(Employee employee) {

    }

    public void add(Departament departament) {

        if(size == departaments.length) {
            Departament[] newDepartaments;
            newDepartaments = new Departament[this.departaments.length * 2];
            System.arraycopy(this.departaments, 0, newDepartaments, 0, this.departaments.length + 1);
            this.departaments = newDepartaments;
        }
        departaments[size] = departament;

        this.size++;
    }


    public void remove(String name) {

        for (int i = 0; i < departaments.length; i++) {
            if (departaments[i].getName().equals(name)) {
                shift(i);
                this.departaments[size] = null;
                this.size--;
            }
        }
    }

    public Departament getDepartament(String name) {

        for (int i = 0; i < this.size; i++) {

            if (departaments[i].getName().equals(name)) {
                return departaments[i];
            }
        }
        return null;
    }

    public Departament[] getDepartaments() {
        Departament[] newDepartaments = new Departament[this.departaments.length];  //todo имя гавно(DONE)
        System.arraycopy(departaments, 0, newDepartaments, 0, departaments.length);
        return newDepartaments;
    }

    public int size() {
        return size;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0; //todo имя гавно(DONE)
        for (int i = 0; i < size; i++) {
            employeesQuantity += departaments[i].employeeQuantity();
        }
        return employeesQuantity;
    }

    public int employeesQuantity(String jobTitle) {

        int employeesQuantity = 0;//todo имя гавно(DONE)
        Departament departament = new Departament();
        for (int i = 0; i < size; i++) {
            employeesQuantity += departament.employeesQuantity(jobTitle);
        }

        return employeesQuantity;
    }

    public Employee bestEmployee() {
        Employee bestEmployee = departaments[0].bestEmployee(); //todo имя гавно(DONE)
        for (int i = 1; i < size; i++) {
            if(bestEmployee.getSalary() < departaments[i].bestEmployee().getSalary())
                bestEmployee = departaments[i].bestEmployee();
        }
        return bestEmployee;
    }

    @Override
    public int employeeQuantity() {
        return 0;
    }

    @Override
    public Employee[] getEmployees() {
        return new Employee[0];
    }

    @Override
    public Employee[] employeesSortedBySalary() {
        return new Employee[0];
    }

    public Departament getEmployeesDepartament(String firstName, String lastName) {
        for (int i = 0; i < size; i++) {
            if(departaments[i].hasEmployee(firstName, lastName))
                return departaments[i];
        }
        return null;
    }

    //todo аналогично департаментам(DONE)
    private void shift(int i) {
        System.arraycopy(this.departaments, i + 1, this.departaments, i, size - i);
    }

    @Override
    public String getName() {
        return name;
    }


}
