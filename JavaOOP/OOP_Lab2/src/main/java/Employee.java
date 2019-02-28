public class Employee {

    private String firstName;
    private String secondName;
    private String jobTitle;
    private final int DEFAULT_SALARY = 0;
    private int salary;

    //todo литералы - это зло!(DONE)
    //todo конструкторы должны вызывать друг друга(DONE)

    public Employee(){}

    public Employee(String firstName, String secondName) {
        setFirstName(firstName);
        setSecondName(secondName);
        setJobTitle("");
        setSalary(DEFAULT_SALARY);
    }

    public Employee(String firstName, String secondName, String jobTitle, int salary) {

        this(firstName, secondName);
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
