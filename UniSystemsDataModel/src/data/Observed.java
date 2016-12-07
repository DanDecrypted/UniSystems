/*
 *  UniSystems is a development package for SOFT 252 at Plymouth University
 *  It is a system designed to allow cars to be loaned out on a custom basis to 
 *  a member of staff. This project was created and developed by Craig Banyard,
 *  Daniel Scott and Najim Mazidi.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author dansc
 */
public class Observed implements ISubject {
    protected ArrayList<IObserver> observers;
    @Override 
    public Boolean registerObserver(IObserver o) {
        Boolean observerAdded = false;
        if (o != null) {
            if (observers == null) {
                observers = new ArrayList<IObserver>();
            }
            
            if (!observers.contains(o)) {
                observerAdded = observers.add(o);
            }
        }
        return observerAdded;
    }
    
    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean observerRemoved = false;
        //Validate we have something to remove
        if (o != null) {
            if(this.observers != null && observers.size() > 0){
                observerRemoved = observers.remove(o);
            }
        }
        return observerRemoved;
    }
    
    @Override 
    public void notifyObservers() {
        if (observers != null && observers.size() > 0) {
            for (IObserver o : observers) {
                o.update();
            }
        }
    }
}
