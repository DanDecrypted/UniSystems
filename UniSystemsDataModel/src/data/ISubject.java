/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

/**
 *
 * @author dansc
 */
public interface ISubject {
    public Boolean registerObserver(IObserver o);
    public Boolean removeObserver(IObserver o);
    public void notifyObservers();
}
