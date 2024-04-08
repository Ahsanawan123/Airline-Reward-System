// Abstract Class

/**
 * @author Ahsan Awan
 * @Version 1.0
 *
 * Purpose is to an abstract class which is like a
 * "blueprint" to the other classes that extend Tier
 */
public abstract class Tier {


    /**
     * @return the miles
     */
    public abstract int getMiles();

    /**
     * @return the number of cancelled flights
     */
    public abstract int getCancelledFlights();

    /**
     * @return the total number of flights
     */
    public abstract int getFlights();

    /**
     * Function increments the number of flights, cancelled flights, and miles
     * @param isCancelled stores if the passenger's flight was cancelled or not
     */
    public abstract void addFlight(boolean isCancelled);

    /**
     * Increments the number of miles if the flight was cancelled
     * @param isCancelled stores if the passenger's flight was cancelled or not
     */
    public abstract void incrementMi(boolean isCancelled);

} // End of public class Tier




