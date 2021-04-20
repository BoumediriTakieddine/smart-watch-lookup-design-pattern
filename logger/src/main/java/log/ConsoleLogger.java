package log;

import core.lookup.Lookup;
import core.lookup.LookupChangeListener;

/**
 * Hello world!
 *
 */
public class ConsoleLogger implements LookupChangeListener{
    @Override
    public void newServiceIsRegistred(Class service, Object instance) {
            System.out.println("- A new " + service.class + " Service is registred at " + instance);
    }

    @Override
    public void newServiceIsRequested(Class service, Object returnedInstance) {
        Object final returnedInstance = Lookup.GET_INSTANCE().getServiceInstance(service.class);
        System.out.println("- A " + service.class + " Service is requested. The returned instance is at " + returnedInstance);
    }
}
