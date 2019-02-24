public class Organization {

    private String name;
    private Departament[] departaments;

    public Organization(String name) {
        this.name = name;
    }

    public Organization(String name, Departament[] departaments) {
        this.name = name;
        this.departaments = departaments;
    }


}
