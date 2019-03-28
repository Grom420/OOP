package humanresources;

public class DepartamentsManager implements GroupsManager {

    private String name;
    private Departament[] departaments;
    private EmployeeGroup[] groups;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private int groupsSize;
    private int countDeletedGroup;


    public DepartamentsManager(String name, String groupsName) {
        this(name, groupsName,  new Departament[DEFAULT_CAPACITY], new Employee[DEFAULT_CAPACITY]);
    }

    public DepartamentsManager(String name, String groupsName, Departament[] departaments, Employee[] groups) {

        if (departaments.length != 0 && groups.length != 0) {
            Departament[] newDepartamets = new Departament[departaments.length];
            System.arraycopy(departaments, 0, newDepartamets, 0, departaments.length);
            this.departaments = newDepartamets;
            EmployeeGroup[] newEmployees = new EmployeeGroup[groups.length];
            System.arraycopy(groups, 0, newEmployees, 0, groups.length);
            this.groups = newEmployees;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(EmployeeGroup employeeGroup) {
        if (groupsSize == groups.length) {
            EmployeeGroup[] newEmployees;
            newEmployees = new EmployeeGroup[this.groups.length * 2];
            System.arraycopy(this.groups, 0, newEmployees, 0, this.groups.length);
            this.groups = newEmployees;
        }
        this.groups[this.groupsSize] = employeeGroup;
        this.groupsSize++;
    }

    public int groupsQuantity() {
        return groupsSize;
    }

    public EmployeeGroup getEmployeeGroup(String name){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].getName().equals(name))
                return groups[i];
        }
        return null;
    }

    public EmployeeGroup[] getEmployeesGroups(){

        EmployeeGroup[] newGroups = new EmployeeGroup[this.groups.length];
        System.arraycopy(groups, 0, newGroups, 0, groups.length);
        return newGroups;
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


    public void removeDepartament(String name) {

        for (int i = 0; i < departaments.length; i++) {
            if (departaments[i].getName().equals(name)) {
                shiftDepartment(i);
                this.departaments[size] = null;
                this.size--;
            }
        }
    }

    public void remove(String groupName){

        for (int i = 0; i < groups.length; i++) {
            if (groups[i].getName().equals(groupName)) {
                shiftGroups(i);
                this.groups[groupsQuantity()] = null;
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
        Departament[] newDepartaments = new Departament[this.departaments.length];
        System.arraycopy(departaments, 0, newDepartaments, 0, departaments.length);
        return newDepartaments;
    }

    public int size() {
        return size;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += departaments[i].employeeQuantity();
        }
        return employeesQuantity;
    }

    public int employeesQuantity(JobTitilesEnum jobTitle) {

        int employeesQuantity = 0;
        Departament departament = new Departament();
        for (int i = 0; i < size; i++) {
            employeesQuantity += departament.employeesQuantity(jobTitle);
        }

        return employeesQuantity;
    }

    public EmployeeGroup getEmployeeGroup(String firstName, String secondName){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].getEmployee(firstName, secondName) != null){
                return groups[i];
            }
        }
        return null;
    }

    public Employee mostValuableEmployee() {
        Employee bestEmployee = departaments[0].bestEmployee();
        for (int i = 1; i < size; i++) {
            if(bestEmployee.getSalary() < departaments[i].bestEmployee().getSalary())
                bestEmployee = departaments[i].bestEmployee();
        }
        return bestEmployee;
    }

    public int remove(EmployeeGroup employeeGroup){
        for (int i = 0; i < groupsQuantity(); i++) {
            if(groups[i].equals(employeeGroup)) {
                shiftGroups(i);
                countDeletedGroup++;
            }
        }
        return countDeletedGroup;
    }


    private void shiftDepartment(int i) {
        System.arraycopy(this.departaments, i + 1, this.departaments, i, size - i);
    }

    private void shiftGroups(int i){
        System.arraycopy(this.groups, i + 1, this.groups, i, groupsSize - i);
    }

}
