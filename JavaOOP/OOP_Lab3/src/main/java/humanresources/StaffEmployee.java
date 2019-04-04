package humanresources;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class StaffEmployee extends Employee implements BusinessTraveller, Iterable<BusinessTravel> {

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

    @Override
    public int getBonus() {
        return bonus;
    }

    @Override
    public boolean isTraveller() {
        return travelsQuantity > 0;
    }

    @Override
    public boolean isPartTimer() {
        return true;
    }

    @Override
    public boolean isTraveller(LocalDateTime startTravel, LocalDateTime endTravel) {
        for(BusinessTravel businessTravel : this){
            return businessTravel.getStartBusinessTravel().getDayOfMonth() >= startTravel.getDayOfMonth()
                    && businessTravel.getEndBusinessTravel().getDayOfMonth() <= endTravel.getDayOfMonth();
        }
        return false;
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
        BusinessTravel[] getTravels = new BusinessTravel[travelsQuantity];
        int countTravels = 0;
        for(BusinessTravel businessTravel : this){
            getTravels[countTravels++] = businessTravel;
        }
        return getTravels;
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

    @Override
    public Iterator<BusinessTravel> iterator() {
        return new Iterator<BusinessTravel>() {
            ListNode currentT = head;
            @Override
            public boolean hasNext() {
                return currentT.next != null;
            }

            @Override
            public BusinessTravel next() {
                if(hasNext()) {
                    currentT = currentT.next;
                    return currentT.value;
                }
                throw new NoSuchElementException("No element");
            }
        };
    }
}
