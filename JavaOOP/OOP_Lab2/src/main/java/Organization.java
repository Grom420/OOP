public class Organization {

    private String name;
    private Departament[] departaments;
    private int size;

    public Organization(String name) {
        this.name = name;
    }

    public Organization(String name, Departament[] departaments) {
        this.name = name;
        this.departaments = departaments;
    }

    public void add(Departament departament){

        Departament[] newDepartaments = new Departament[this.departaments.length + 1];
        System.arraycopy(this.departaments, 0, newDepartaments, 0, this.departaments.length+1);
        newDepartaments[newDepartaments.length] = departament;
        this.departaments = newDepartaments;
        this.size++;
    }


    public void remove(String name){

        for (int i = 0; i < departaments.length; i++) {
            if(departaments[i].getName().equals(name)){
                shift(i);
            }
        }
    }

    public Departament getDepartament(String name){

        for (int i = 0; i < this.size; i++) {

            if (departaments[i].getName().equals(name)) {
                return departaments[i];
            }
        }
        return null;
    }

    public Departament[] getDepartaments(){

        return this.departaments;
    }

    public int size(){

        int count = 0;
        for (int i = 0; i < this.size; i++) {
            count++;
        }
        return count;
    }

    public int employeesQuantity(){

        int count = 0;

        for (int i = 0; i < departaments.length; i++) {

            count += departaments[i].size();
        }
        return count;
    }

    public int employeesQuantity(String jobTitle){

        Employee[] employees;
        int count = 0;

        for (int i = 0; i < departaments.length; i++) {
            employees = departaments[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {
                if(employees[j].getJobTitle().equals(jobTitle))
                    count++;
            }
        }
        return count;
    }

    public Employee bestEmployee() {

        Employee[] employees = departaments[0].getEmployees();
        Employee bestEmp = employees[0];
        int total = 0;
        for (int i = 0; i < departaments.length; i++) {

            employees = departaments[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {

                if (employees[j].getSalary() > total) {

                    total = employees[i].getSalary();
                    bestEmp = employees[i];
                }
            }
        }
        return bestEmp;
    }

    public Departament getEmployeesDepartament(String firstName, String lastName){

        Employee[] employees;

        for (int i = 0; i < departaments.length; i++) {

            employees = departaments[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {

                if(employees[j].getFirstName().equals(firstName) && employees[j].getSecondName().equals(lastName)){
                    return departaments[i];
                }
            }
        }
        return null;
    }

    private void shift(int i){

        System.arraycopy(this.departaments, i+1, this.departaments, i, size-i);
        this.departaments[size] = null;
        this.size--;
    }
}
