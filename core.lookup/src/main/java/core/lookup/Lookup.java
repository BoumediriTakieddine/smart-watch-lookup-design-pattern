/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.lookup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Lookup {
    private static Lookup INSTANCE;
    private static final Object lock = null;
    private final Map<Class, Object> services = new HashMap<>() ;
    Set<LookupChangeListener> listeners = new HashSet<>() ;
    
    private Lookup() {		
    }

    public static Lookup GET_INSTANCE () {
        if(INSTANCE == null)
                    INSTANCE = new Lookup();
        return INSTANCE ; 
    }

    public <T> void registerServiceInstance (Class<? super T> service, T instance) {
        services.put(service, instance) ;
        for (LookupChangeListener l : listeners)
                l.newServiceIsRegistred(service, instance);
    }

    public <T> T getServiceInstance(Class<T> service) {
        T instance = (T) (services.get(service)) ;
        if(instance != null) {
            for (LookupChangeListener l : listeners)
                l.newServiceIsRequested(service, instance);
        }
        return instance ; 
    }
    
    public void addListener (LookupChangeListener l) {
        if(l != null)
            listeners.add(l) ;
    }

    public void removeListener (LookupChangeListener l) {
        if(l != null)
            listeners.remove(l) ;
    }

}
