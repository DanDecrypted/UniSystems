/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

/**
 * Observer interface to guarantee the update behaviour
 * @author dansc
 */
public interface IObserver {
    public void update();
}
