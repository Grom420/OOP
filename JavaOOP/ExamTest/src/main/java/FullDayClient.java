import java.time.LocalDateTime;

public class FullDayClient extends DayClient{

    public FullDayClient(String name, String lastName, LocalDateTime birthday) {
        this(name, lastName, birthday, LocalDateTime.now(), 12);
    }

    public FullDayClient(String name, String lastName, LocalDateTime birthday, LocalDateTime dateOfRegistry, long endMonthRegistry) {
        super(name, lastName, birthday, dateOfRegistry, endMonthRegistry);
    }
}
