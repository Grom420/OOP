import humanresources.JobTitilesEnum;

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

    abstract int setBonus();

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

    private boolean isDone(Object obj){

        if (!obj.equals(null) && !obj.equals("") && !obj.equals(0) && !obj.equals("null"))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        if(isDone(secondName) && isDone(firstName) && isDone(jobTitle) && isDone(salary))
            return secondName + " " + firstName + "," + jobTitle + "," + salary;
        else return null;
    }
}
