package humanresources;

import java.time.LocalDateTime;
import java.util.Objects;

public final class BusinessTravel {

    private int compensation;
    private LocalDateTime startBusinessTravel;
    private LocalDateTime endBusinessTravel;
    private int daysCount;
    private String description;
    private String destination;

    private final static int DEFAULT_COMPENSATION = 0;
    private final static LocalDateTime DEFAULT_START_BUSINESS_TRAVEL = LocalDateTime.now();
    private final static LocalDateTime DEFAULT_END_BUSINESS_TRAVEL = LocalDateTime.now().plusDays(1);
    private final static String DEFAULT_DESCRIPTION = "";
    private final static String DEFAULT_DESTINATION = "";

    public BusinessTravel() throws IllegalDatesException {
        this(DEFAULT_COMPENSATION, DEFAULT_DESCRIPTION, DEFAULT_DESTINATION, DEFAULT_START_BUSINESS_TRAVEL, DEFAULT_END_BUSINESS_TRAVEL);
    }

    public LocalDateTime getStartBusinessTravel() {
        return startBusinessTravel;
    }

    public LocalDateTime getEndBusinessTravel() {
        return endBusinessTravel;
    }

    public BusinessTravel(int compensation, String description, String destination, LocalDateTime startBusinessTravel, LocalDateTime endBusinessTravel) throws IllegalDatesException {
        this.description = description;
        this.destination = destination;

        if(startBusinessTravel.getDayOfYear() > endBusinessTravel.getDayOfYear())
            throw new IllegalDatesException("Illegal date argument");
        if(compensation < 0)
            throw new java.lang.IllegalArgumentException("Illegal compensation argument");
            //todo по каждому случаю свой эксепшен со своим сообщением(DONE)
        this.startBusinessTravel = startBusinessTravel;
        this.daysCount = getDaysCount();
        this.endBusinessTravel = endBusinessTravel;
        this.compensation = compensation;
    }

    public int getCompensation() {
        return compensation;
    }

    public int getDaysCount() {
        return startBusinessTravel.getDayOfMonth() + endBusinessTravel.getDayOfMonth();
    }

    public String getDescription() {
        return description;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessTravel that = (BusinessTravel) o;
        return getCompensation() == that.getCompensation() &&
                getDaysCount() == that.getDaysCount() &&
                startBusinessTravel.equals(that.startBusinessTravel) &&
                endBusinessTravel.equals(that.endBusinessTravel) &&
                getDescription().equals(that.getDescription()) &&
                getDestination().equals(that.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompensation(), startBusinessTravel, endBusinessTravel, getDaysCount(), getDescription(), getDestination());
    }

    @Override
    public String toString() {
        return String.format("%s %d (%d). %s", destination, daysCount, compensation, description);
    }
}
