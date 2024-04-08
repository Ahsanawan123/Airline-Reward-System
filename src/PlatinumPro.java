/**
 * This class  extends a parent class called "Tier", and it implements methods for adding and getting information
 * (If passenger has 50 or more cancellations, and they haven't complained throughout the whole year, they are put
 * into the Platinum Pro tier)
 * @Author Ahsan Awan
 * @Version 1.0
 */
public class PlatinumPro extends Tier {
    private int miles; // Stores the miles the passenger accumulates
    private int numOfCanceledFlights; // Stores the number of cancelled flights
    private int numOfTotFlights;  // Stores the number of total flights

    /**
     * Creates an object and assigns respectively
     */
    PlatinumPro (int Mi, int numCanFlights, int numTotFlights) {
        miles = Mi;
        numOfCanceledFlights = numCanFlights;
        numOfTotFlights = numTotFlights;
    } // End of platinum pro

    /**
     *
     * @return passenger's miles
     */
    @Override
    public int getMiles() {
        return miles * 2; // Returns the miles doubled since multiplier doubles the miles
    } // end of getMiles

    /**
     *
     * @return number of cancelled flights
     */
    @Override
    public int getCancelledFlights() {
        return numOfCanceledFlights;
    } // End of getCancelled flights

    /**
     *
     * @return returns total number of flights
     */
    @Override
    public int getFlights() {
        return numOfTotFlights;
    } // End of getFlights

    /**
     * Add's the total number of flights, and if cancelled, add's the number of cancelled flights for a passenger
     *
     * @param isCancelled stores if the passenger's flight was cancelled or not
     */
    @Override
    public void addFlight(boolean isCancelled) {
        numOfTotFlights += 1; // increments total flights

        // if passenger cancels
        if (isCancelled) {
            numOfCanceledFlights += 1; // Increments cancelled flights
        }  // End of if

        incrementMi(isCancelled);  // Increment miles is called and is passed isCancelled
    }  // End of addFlight

    /**
     * If passenger cancels, they are awarded  double the miles
     * @use in method addFlight(boolean isCancelled) to increment the miles of a passenger
     * @param isCancelled stores if the passenger's flight was cancelled or not
     */
    @Override
    public void incrementMi(boolean isCancelled) {

        // if cancelled
        if (isCancelled) {
            miles += 1000; // miles are doubled with special sub-tiers; multiplier is on
        } // End of if
    } // End of incrementMi
} // End of public Class Platinum Pro

