package humanresources;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;

public class StaffEmployee extends Employee implements BusinessTraveller, Iterable<BusinessTravel> {

    private int bonus;
    private ListNode head;
    private ListNode tail;
    private int travelsQuantity;

    private static final int DEFAULT_BONUS = 0;

    public StaffEmployee(String secondName, String firstName){
        super(firstName, secondName, 0);
        this.bonus = DEFAULT_BONUS;
        setJobTitle(JobTitilesEnum.NONE);
    }

    public StaffEmployee(String firstName, String secondName, JobTitilesEnum jobTitle, int salary){
        this(firstName, secondName, jobTitle, salary, new BusinessTravel[16]);
    }

    public StaffEmployee(String firstName, String secondName, JobTitilesEnum jobTitle, int salary, BusinessTravel[] businessTravels){
        super(firstName, secondName);
        setJobTitle(jobTitle);
        setSalary(salary);
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
    public int size() {
        return this.travelsQuantity;
    }

    @Override
    public boolean isEmpty() {
        return (travelsQuantity == 0);
    }

    @Override
    public boolean contains(Object o) {
        for(BusinessTravel businessTravel : this){
            if(businessTravel.equals(o))
                return true;
        }
        return false;
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

    @Override
    public Object[] toArray() {
        BusinessTravel[] businessTravels = new BusinessTravel[this.travelsQuantity];
        int j = 0;
        for (BusinessTravel businessTravel : this) {
            if (businessTravel != null)
                businessTravels[j++] = businessTravel;
        }
        return businessTravels;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < travelsQuantity)
            return (T[]) Arrays.copyOf(toArray(), travelsQuantity -1, a.getClass());
        System.arraycopy(toArray(), 0, a, 0, travelsQuantity);
        if (a.length > travelsQuantity)
            a[travelsQuantity] = null;
        return a;
    }

    @Override
    public boolean add(BusinessTravel businessTravel) {
        ListNode a = new ListNode();
        a.value = businessTravel;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            if(businessTravel.getStartBusinessTravel().isBefore(tail.prev.value.getEndBusinessTravel())
                    && businessTravel.getStartBusinessTravel().isAfter(a.value.getStartBusinessTravel()))
                throw new IllegalArgumentException("illegal date");
            tail.next = a;
            tail = a;
            travelsQuantity++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (head.value.equals(o))  {
            head = head.next;
            this.travelsQuantity--;
        }

        ListNode currentT = head;
        while (currentT.next != null) {
            if (currentT.next.value.equals(o)) {
                if (tail.value.equals(currentT.next.value)) {
                    tail = currentT;
                }
                currentT.next = currentT.next.next;
                this.travelsQuantity--;
            }
            currentT = currentT.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(Collection<? extends BusinessTravel> c) {
        if (c.size() > travelsQuantity) {
            try {
                throw new AlreadyAddedException("There are not enough of free travels");
            } catch (AlreadyAddedException e) {
                e.printStackTrace();
            }
        }
        ListNode currentT = head;
        for (BusinessTravel o : c) {
            currentT.value = o;
            currentT = currentT.next;
        }
        return true;
    }

    private <T> int removeAll(BiPredicate<T, BusinessTravel> biPredicate, T obj) {
        int removedBusinessTravelCount = 0;
        ListNode currentT = head;
        while (currentT.next != null){
            if(biPredicate.test(obj, currentT.value)) {
                remove(currentT);
                removedBusinessTravelCount++;
            }
            currentT = currentT.next;
        }
        return removedBusinessTravelCount;
    }

    private BiPredicate<Collection<?>, BusinessTravel> containsInCollection = Collection::contains;
    private BiPredicate<Collection<?>, BusinessTravel> notContainsInCollection = (c, o) -> !c.contains(o);

    @Override
    public boolean removeAll(Collection<?> c) {
        return removeAll(containsInCollection, c) > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return removeAll(notContainsInCollection, c) > 0;
    }


    @Override
    public void clear() {
        ListNode currentNode = head;
        while (currentNode.next != null){
            currentNode.value = null;
            currentNode = currentNode.next;
        }
    }

    @Override
    public int compareTo(Employee o) {
        return (this.getBonus() + this.getSalary()) - (o.getBonus() - o.getSalary());
    }
}
