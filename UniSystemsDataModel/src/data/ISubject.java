/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

/**
 * Subject interface
 * @author dansc
 */
public interface ISubject {
    /**
     * Registers an observer to the subject
     * @param o the observer to add
     * @return true or false depending on whether it succeeded or not
     */
    public Boolean registerObserver(IObserver o);
    
    /**
     * Removes an observer from the subject.
     * @param o the observer to remove
     * @return true or false depending on whether it succeeded or not.
     */
    public Boolean removeObserver(IObserver o);
    
    /**
     * removes all observers from the list
     */
    public void removeObservers();    
    
    /**
     * Notifies all the observers that there has been a change.
     */
    public void notifyObservers();
}
