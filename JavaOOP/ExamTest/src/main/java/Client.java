import java.time.LocalDateTime;

public class Client {
    private String name;
    private String lastName;
    private LocalDateTime birthday;
    private LocalDateTime dateOfRegistry;

    public Client(String name, String lastName, LocalDateTime birthday){
        this(name, lastName, birthday, LocalDateTime.now());
    }

    public Client(String name, String lastName, LocalDateTime birthday, LocalDateTime dateOfRegistry){
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.dateOfRegistry = dateOfRegistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getDateOfRegistry() {
        return dateOfRegistry;
    }

    public void setDateOfRegistry(LocalDateTime dateOfRegistry) {
        this.dateOfRegistry = dateOfRegistry;
    }
}
