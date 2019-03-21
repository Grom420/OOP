package humanresources;

import java.util.Objects;

public final class BusinessTravel {

    private int compensation;
    private int daysCount;
    private String description;
    private String destination;

    private final static int DEFAULT_COMPENSATION = 0;
    private final static int DEFAULT_DAYS_COUNT = 0;
    private final static String DEFAULT_DESCRIPTION = "";
    private final static String DEFAULT_DESTINATION = "";


    public BusinessTravel(){

        this.compensation = DEFAULT_COMPENSATION;
        this.daysCount = DEFAULT_DAYS_COUNT;
        this.description = DEFAULT_DESCRIPTION;
        this.destination = DEFAULT_DESTINATION;
    }

    public BusinessTravel(int compensation, int daysCount, String description, String destination) {
        this.compensation = compensation;
        this.daysCount = daysCount;
        this.description = description;
        this.destination = destination;
    }

    public int getCompensation() {
        return compensation;
    }

    public int getDaysCount() {
        return daysCount;
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
                getDescription().equals(that.getDescription()) &&
                getDestination().equals(that.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(compensation) ^ Objects.hash(daysCount) ^ Objects.hash(description) ^ Objects.hash(destination);
    }

    @Override
    public String toString() {
        return destination + " " + daysCount + " (" + compensation + "). " + description;
    }
}
