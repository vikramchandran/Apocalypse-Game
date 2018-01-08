import greenfoot.*;
import java.util.List;
import java.util.ArrayList;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SleepingAlien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SleepingAlien extends NonMover implements Destroyer
   {
    /**
     * Act - do whatever the SleepingAlien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public SleepingAlien( )
       {
       super();
       }

       
    public void destroy()
       {
      if( isTouching( Survivor.class ) )
          {
          super.populateEnemySurvivor();
          getWorld().removeObject( this );
          super.returnEnemySurvivor().hitAlien();
          super.returnEnemySurvivor().lostgame();
          }
       } // the hitAlien code is unique to the SleepingAlien destroy method
    
        
    public void act() 
       {
       remove();
       } // This spawning is adopted from its superclass, "NonMover"
   }
