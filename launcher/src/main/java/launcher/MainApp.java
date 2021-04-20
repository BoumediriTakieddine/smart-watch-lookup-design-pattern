/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import core.lookup.Lookup;
import util.impl.gui.GuiImpl;
import util.impl.timer.TimerImplementation;
import util.service.gui.GuiService;
import util.service.timer.TimerService;


/**
 *
 * @author BOUMEDIRI
 */
public class MainApp 
{
    static GuiImpl gui;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Lookup lookup = Lookup.GET_INSTANCE();
        gui =  new GuiImpl();
        TimerImplementation timer = new TimerImplementation();
        
        lookup.registerServiceInstance(GuiService.class, gui);
        lookup.registerServiceInstance(TimerService.class, timer);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });
    }
}