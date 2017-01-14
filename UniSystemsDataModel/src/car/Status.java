/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package car;

/**
 * list of statuses known to the system
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public enum Status {
    AVAILABLE, 
    AWAITING_PREP,
    AWAITING_REPAIR, 
    AWAITING_SALE,
    DAMAGED,
    IN_FOR_SERVICE,
    OUT_ON_LOAN,
    SOLD
}
