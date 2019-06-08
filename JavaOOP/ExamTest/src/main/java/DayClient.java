import java.time.LocalDateTime;

public class DayClient extends Client {
    private LocalDateTime endDateOfRegistry;

    public DayClient(String name, String lastName, LocalDateTime birthday) {
        this(name, lastName, birthday, LocalDateTime.now(), 12);
    }

    public DayClient(String name, String lastName, LocalDateTime birthday, LocalDateTime dateOfRegistry, long endMonthRegistry) {
        super(name, lastName, birthday, dateOfRegistry);
        this.endDateOfRegistry = LocalDateTime.now().plusMonths(endMonthRegistry);
    }

    public LocalDateTime getEndDateOfRegistry() {
        return endDateOfRegistry;
    }

    public void setEndDateOfRegistry(LocalDateTime endDateOfRegistry) {
        this.endDateOfRegistry = endDateOfRegistry;
    }
}
