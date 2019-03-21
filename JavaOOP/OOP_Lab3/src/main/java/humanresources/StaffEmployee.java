package humanresources;

import java.util.Objects;

public class StaffEmployee extends Employee implements BusinessTraveller {

    private int bonus;
    private ListNode head;
    private int travelsQuantity;

    private static final int DEFAULT_BONUS = 0;
    private static final ListNode DEFAULT_HEAD = null;

    public StaffEmployee(String secondName, String firstName){
        super(firstName, secondName, 0);
        this.bonus = DEFAULT_BONUS;
        this.head = DEFAULT_HEAD;
        setJobTitle(JobTitilesEnum.NONE);
    }

    public StaffEmployee(String firstName, String secondName, JobTitilesEnum jobTitle, int salary){
        this(firstName, secondName, jobTitle, salary, new BusinessTravel[16]);
    }

    public StaffEmployee(String firstName, String secondName, JobTitilesEnum jobTitle, int salary, BusinessTravel[] businessTravels){
        super(firstName, secondName);
        setJobTitle(jobTitle);
        setSalary(salary);
        this.head = DEFAULT_HEAD;
        this.bonus = DEFAULT_BONUS;
    }

    public boolean isTravel(Employee employee){
        return false;
    }

    @Override
    public int getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void addTravel(BusinessTravel travel) {


    }

    @Override
    public BusinessTravel[] getTravels() {
        return new BusinessTravel[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaffEmployee that = (StaffEmployee) o;
        return getBonus() == that.getBonus() &&
                travelsQuantity == that.travelsQuantity &&
                head.equals(that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()) ^ Objects.hash(getBonus()) ^ Objects.hash(head) ^ Objects.hash(travelsQuantity);
    }

    @Override
    public String toString() {
        return getSecondName() + " " + getFirstName() + " " + getJobTitle() + " " + getSalary() + "р. " + getBonus() + "р. " + "Командировки \n" +
                head.value.toString();
    }
}
