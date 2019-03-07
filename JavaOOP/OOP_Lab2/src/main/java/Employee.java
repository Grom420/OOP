public class Employee {

    private String firstName;
    private String secondName;
    private String jobTitle;
    private static final int DEFAULT_SALARY = 0;
    private int salary;

    public Employee(){}

    public Employee(String firstName, String secondName) {
        this(firstName, secondName, "", DEFAULT_SALARY);

    }

    public Employee(String firstName, String secondName, String jobTitle, int salary) {
        setFirstName(firstName);
        setSecondName(secondName);
        setJobTitle(jobTitle);
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
