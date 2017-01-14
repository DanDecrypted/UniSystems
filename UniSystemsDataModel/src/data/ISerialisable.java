/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

/**
 *
 * @author Craig Banyard, Daniel Scott, Najim Mazidi
 */
public interface ISerialisable {

    /**
     * Loads the ArrayList data 
     * @return a string containing any error messages/successes.
     */
    public abstract String loadFromDisk();

    /**
     * Saves the ArrayList data
     * @return a string containing any error messages/successes.
     */
    public abstract String saveToDisk();
}
