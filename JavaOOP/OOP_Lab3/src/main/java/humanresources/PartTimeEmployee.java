package humanresources;
import java.util.Objects;

public class PartTimeEmployee extends Employee {

    private int bonus;

    PartTimeEmployee(){
        super();
    }

    PartTimeEmployee(String firstName, String secondName){
        super(firstName, secondName);
    }

    PartTimeEmployee(String firstName, String secondName, int salary){

        super(firstName, secondName, salary);
    }

    @Override
    int getBonus() {
        return this.bonus;
    }

    @Override
    public boolean isTraveller() {
        return false;
    }

    @Override
    public boolean isPartTimer(){
        return bonus != 0;
    }

    @Override
    void setBonus(int bonus) { }


    @Override
    public String toString() {

            return getSecondName() + " " + getFirstName() + "," + getJobTitle() + "(Внешний совместитель)," + getSalary() + "р.";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PartTimeEmployee that = (PartTimeEmployee) obj;
        return Double.compare(that.getSalary(), getSalary()) == 0 &&
                getSecondName().equals(that.getSecondName()) &&
                getFirstName().equals(that.getFirstName()) &&
                getJobTitle().equals(that.getJobTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName()) ^ Objects.hash(getSecondName()) ^ Objects.hash(getJobTitle()) ^ Objects.hash(getSalary());
    }
}
