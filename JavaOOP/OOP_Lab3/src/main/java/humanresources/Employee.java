package humanresources;

import java.util.Objects;

abstract public class Employee {

    private String firstName;
    private String secondName;
    private JobTitilesEnum jobTitle;
    private static final int DEFAULT_SALARY = 0;
    private int salary;

    protected Employee(){}

    protected Employee(String firstName, String secondName) {
        this(firstName, secondName, DEFAULT_SALARY);

    }

    protected Employee(String firstName, String secondName, int salary) {
        setFirstName(firstName);
        setSecondName(secondName);
        setJobTitle(JobTitilesEnum.NONE);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public JobTitilesEnum getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitilesEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    abstract int getBonus();

    public abstract boolean isTraveller();

    public abstract boolean isPartTimer();

    abstract void setBonus(int bonus);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return salary == employee.salary &&
                firstName.equals(employee.firstName) &&
                secondName.equals(employee.secondName) &&
                jobTitle == employee.jobTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, jobTitle, salary);
    }

    @Override
    public String toString() {
        if(!secondName.equals("") && !firstName.equals("")
                && !jobTitle.equals(JobTitilesEnum.NONE)
                && salary != 0)
            //todo String.format(DONE)
            return String.format("%s %s, %s, %d", secondName, firstName, jobTitle.toString(), salary);
        else return "";
    }
}
