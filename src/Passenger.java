/**
 * @author Ahsan Awan
 * @Version 1.0
 *
 *  Passenger class has attributes such as passenger tier, passenger ID, flight cancellation status, and a flag for
 *  passenger complaints. The program also includes methods to get the passenger ID, passenger tier, miles, and the
 *  number of canceled flights. Additionally, there are methods for upgrading a passenger's tier based on the
 *  number of canceled flights and complaints. The class uses different tiers such as Gold, Platinum, Platinum Pro,
 *  Executive Platinum, and Super Executive Platinum to determine the passenger's loyalty status.
 */
public class Passenger {
    private Tier passengerTier; // The Tier passengerTier is used to store and track
                                // the level of membership or tier of the passenger
    private int PassengerID; // Stores the passenger's ID
    private boolean FlightCanceled; // Stores if the passenger's flight was cancelled

    private boolean passengerComplained; // Stores if the passenger complained or not

    /**
     * The passenger constructor initializes the passenger object with the
     * given passenger ID, flight cancellation status, and complaint status.
     *
     * @param PassID represents the passenger's ID that is passed
     * @param FlightCan represents if the passenger's flight was cancelled
     * @param PassComplained represents if the passenger complained
     */
    Passenger (int PassID, char FlightCan, char PassComplained) {
        Tier PassengerInfo = new NoTier(); // Creates a tier object to store
                                           // passenger information

        this.passengerTier = PassengerInfo; // Stores the passenger's information
                                            // in the current tier
        this.PassengerID = PassID; // Store's the user id

        // If the flight was cancelled
        if (FlightCan == 'Y') {
            this.FlightCanceled = true; // Stores true
        } // End of if
        // If flight wasn't cancelled
        else {
           this.FlightCanceled = false; // Stores false
        } // End of else
        this.addFlight(this.FlightCanceled);  // Update's the passenger's total flights and cancelled flights

        // If passenger complained
        if (PassComplained == 'Y') {
            this.passengerComplained = true; // Stores true
        } // End of if
        // Else if passenger didn't complain
        else {
            this.passengerComplained = false; // Store's false
        } // End of else
    } // End of passenger

    /**
     * Executes true if passenger complained
     */
    public void passComplained () {
        this.passengerComplained = true;
    } // End of passComplained

    /**
     *
     * @return passenger ID
     */
    public int getPassID() {
        return PassengerID;
    } // End of getPassID


    /**
     * Function Returns the Tier Name of the account
     * @return the tier level of a user account.
     */
    public String getTier() {

        // If passengerTier is null
        if (passengerTier == null) {
            return "No Tier"; // Returns no Tier if it's null
        } // End of if

        // If passenger is Gold Tier
        if (passengerTier instanceof Gold) {
            return "Gold"; // Returns Gold
        } // End of if

        // If passenger is Platinum Tier
        if (passengerTier instanceof Platinum) {
           return "Platinum"; // Returns Platinum Tier
        } // End of if

        // If passenger is Platinum Pro Tier
        if (passengerTier instanceof PlatinumPro) {
            return "Platinum Pro"; // Returns Platinum Pro
        } // End of if

        // If passenger is Executive platinum
        if (passengerTier instanceof ExecutivePlatinum) {
            return "Executive Platinum"; // Return Executive Platinum
        } // End of if

        // If passenger is Super Executive Platinum
        if (passengerTier instanceof SuperExecutivePlatinum) {
            return "Super Executive Platinum"; // Returns Super Executive Platinum
        } // End of if

        return "No Tier"; // Automatically returns no Tier if none above
    } // End of getTier

    /**
     *
     * @return passenger's total miles
     */
    public int getMiles() {
       return passengerTier.getMiles();
    } // End of getMiles

    /**
     *
      * @return the number of cancelled flights
     */
    public int getCancelledFlights() {
        return passengerTier.getCancelledFlights();
    } // End of getCancelledFlights

    /**
     *
     * @return True if passenger has multiplier, false if vice versa
     */
    public boolean hasMultiplier () {

        // If passengerTier is null
        if (passengerTier == null) {
            return false;
        } // End of if

        // If passenger's tier is Platinum Pro
        if (passengerTier instanceof PlatinumPro) {
            return true;
        } // End of if

        // If passenger's Tier is Super Executive Platinum
        if (passengerTier instanceof SuperExecutivePlatinum) {
            return true;
        } // End of if

        return false; // Automatically returns false if none of the above
    } // End of hasMultiplier

    /**
     * @use in upgradePass() to set the passenger's tier
     * @param givenTier holds the passenger's tier that assigns a tier or category to a passenger object.
     */
    public void setPassengerTier (String givenTier) {

        // If tier is Gold
        if (givenTier.equals("Gold")) {
            Gold PassengerInfo = new Gold(passengerTier.getMiles(),passengerTier.getCancelledFlights(), passengerTier.getFlights());
            this.passengerTier = PassengerInfo; // Makes a gold object and assigns it to passengerTier
        } // End of if

        // If tier is Platinum
        if (givenTier.equals("Platinum")) {
            Platinum PassengerInfo = new Platinum(passengerTier.getMiles(),passengerTier.getCancelledFlights(), passengerTier.getFlights());
            this.passengerTier = PassengerInfo; // makes a platinum object and assigns it to passengerTier
        } // End of if

        // If tier is platinum pro
        if (givenTier.equals("Platinum Pro")) {
            PlatinumPro PassengerInfo = new PlatinumPro(passengerTier.getMiles(),passengerTier.getCancelledFlights(), passengerTier.getFlights());
            this.passengerTier = PassengerInfo; // Makes a Platinum Pro object and assigns it to passengerTier
        } // End of if

        // If tier is Executive platinum
        if (givenTier.equals("Executive Platinum")) {
            ExecutivePlatinum PassengerInfo = new ExecutivePlatinum(passengerTier.getMiles(),passengerTier.getCancelledFlights(), passengerTier.getFlights());
            this.passengerTier = PassengerInfo;  // Makes an Executive Platinum object and assigns it to passengerTier
        } // End of if

        // If tier is Super Executive platinum
        if (givenTier.equals("Super Executive Platinum")) {
            SuperExecutivePlatinum PassengerInfo = new SuperExecutivePlatinum(passengerTier.getMiles(),passengerTier.getCancelledFlights(), passengerTier.getFlights());
            this.passengerTier = PassengerInfo; // Makes a Super Executive Platinum object and assigns it to passengerTier
        } // End of if
    } // End of setPassengerTier

    /**
     *
     * @param isCancelled represents the passenger's flight that was either cancelled or not cancelled
     */
    public void addFlight (boolean isCancelled) {
        passengerTier.addFlight(isCancelled); // calls the addFlight method in the respective Tier class
        upgradePassWithoutSubTiers(); // calls the method in the passenger class to upgrade the passenger's tier

    } // End of addFlight

    /**
     * @use in addFlight( boolean isCancelled) to assign the proper tier during reading the file
     * upgrades passenger's tier to either Gold, platinum, or executive platinum, to update those upgrading tiers but
     * not sub tiers (special tiers)
     */
    public void upgradePassWithoutSubTiers () {

        // if user has or over 100 cancelled flights
        if (passengerTier.getCancelledFlights() >= 100) {
            this.setPassengerTier("Executive Platinum"); // sets tier to executive platinum
        } else if (passengerTier.getCancelledFlights() >= 50) { // if user has between 50 - 100 cancellations
            this.setPassengerTier("Platinum"); // sets tier to platinum; end of else if
        } else if (passengerTier.getCancelledFlights() >= 25) { // if user has between 25- 50 cancellations
            this.setPassengerTier("Gold"); // sets tier to gold
        } // End of else if
    } // end of upgradePassWithoutSubTiers

    /**
     * Upgrades Passenger tier to All tiers
     */
    public void upgradePass () {

        // If passenger achieved 100 cancellations and no complaints
        if (passengerTier.getCancelledFlights() >= 100 && !(passengerComplained)) {
            this.setPassengerTier("Super Executive Platinum"); // sets tier to Super Executive platinum

        } // End of if

        // Else if passenger achieved 100 cancellations and complained
        else if (passengerTier.getCancelledFlights() >= 100) {
            this.setPassengerTier("Executive Platinum"); // sets tier to executive platinum
        } // End of if

        // If passenger achieves 50 cancellations and doesn't complain
        else if (passengerTier.getCancelledFlights() >= 50 && !(passengerComplained)) {
            this.setPassengerTier("Platinum Pro"); // sets tier to platinum pro
        } // End of if

        // If passenger achieves 50 cancellations and complains
        else if (passengerTier.getCancelledFlights() >= 50) {
            this.setPassengerTier("Platinum"); // sets tier to platinum
        } // end of if

        // If passenger achieves 25 flights
        else if (passengerTier.getCancelledFlights() >= 25) {
            this.setPassengerTier("Gold"); // sets tier to gold
        } // End of if
    } // End of upgradePass
} // End of public class Passenger
