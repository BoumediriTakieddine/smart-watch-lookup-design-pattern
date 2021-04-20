package util.impl.timer;

import core.lookup.Lookup;
import java.util.Timer;
import java.util.TimerTask;
import util.service.gui.GuiService;
import util.service.timer.TimerService;

/**
 *
 * @author BOUMEDIRI
 */


public class TimerImplementation implements TimerService {

    public TimerImplementation() {
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                oneSecondElapsed();
            }
        };

        Timer tt = new Timer();
        tt.scheduleAtFixedRate(t, 0, 1000);
    }

    @Override
    public void oneSecondElapsed() {
        GuiService gui = Lookup.GET_INSTANCE().getServiceInstance(GuiService.class);
        gui.showTime();
    }

    
}
