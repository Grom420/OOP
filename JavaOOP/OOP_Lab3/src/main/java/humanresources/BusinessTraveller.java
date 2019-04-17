package humanresources;

import java.time.LocalDateTime;
import java.util.Set;

public interface BusinessTraveller extends Set<BusinessTravel> {

    public BusinessTravel[] getTravels();
    public boolean isTraveller();
    public boolean isTraveller(LocalDateTime startTravel, LocalDateTime endTravel);

}
