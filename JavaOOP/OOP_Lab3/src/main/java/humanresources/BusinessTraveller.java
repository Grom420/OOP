package humanresources;

import java.time.LocalDateTime;

public interface BusinessTraveller {

    public void addTravel(BusinessTravel travel);
    public BusinessTravel[] getTravels();
    public boolean isTraveller();
    public boolean isTraveller(LocalDateTime startTravel, LocalDateTime endTravel);

}
