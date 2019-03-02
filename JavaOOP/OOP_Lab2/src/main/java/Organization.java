public class Organization {

    private String name;
    private Departament[] departaments;
    private final int DEFAULT_CAPACITY = 16;
    private int size;


    public Organization(String name) {
        setName(name);
        //todo init departments(DONE)
        this.departaments = new Departament[DEFAULT_CAPACITY];
    }

    public Organization(String name, Departament[] departaments) {

        this(name);
        if (departaments.length != 0) {
            Departament[] bufDep = new Departament[departaments.length];
            System.arraycopy(departaments, 0, bufDep, 0, departaments.length);
            this.departaments = bufDep; //todo copy elements(DONE)
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Departament departament) {
        //todo if(size == length)(DONE)
        Departament[] newDepartaments;
        if(size == departaments.length){

            newDepartaments = new Departament[this.departaments.length * 2];
        }
        else{
            newDepartaments = new Departament[this.departaments.length];
        }
        System.arraycopy(this.departaments, 0, newDepartaments, 0, this.departaments.length + 1);
        newDepartaments[newDepartaments.length] = departament;
        this.departaments = newDepartaments;
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

        //todo озвращай копию массива(DONE)
        Departament[] newDep = new Departament[this.departaments.length];
        System.arraycopy(departaments, 0, newDep, 0, departaments.length);
        return newDep;
    }

    public int size() {

        return size;
    }

    public int employeesQuantity() {

        int count = 0;


        //todo for до size(DONE)
        for (int i = 0; i < size; i++) {

            Departament departament = departaments[i];
            count += departament.size();
        }
        return count;
    }

    public int employeesQuantity(String jobTitle) {

        //todo department.employeesQuantity(jobtitle)(DONE)
        int count = 0;
        Departament departament = new Departament();
        for (int i = 0; i < size; i++) {

            count += departament.employeesQuantity(jobTitle);
        }

        return count;
    }

    public Employee bestEmployee() {
        //todo department.bestmployee()(DONE)
        Employee employeeBuf = departaments[0].bestEmployee();
        int total = 0;
        for (int i = 1; i < size; i++) {

            if(employeeBuf.getSalary() < departaments[i].bestEmployee().getSalary())
                employeeBuf = departaments[i].bestEmployee();
        }
        return employeeBuf;
    }

    public Departament getEmployeesDepartament(String firstName, String lastName) {

        //todo department.hasEmployee()(DONE)

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
}
