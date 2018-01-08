import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class C4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class C4 extends NonMover implements Destroyer
{
    /**
     * Act - do whatever the C4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */



    public C4( )
       {
       super( );
       }
    
    
    public void destroy()
       {
      if( isTouching( Survivor.class ) )
          {
          super.populateEnemySurvivor();
          getWorld().removeObject( this );
          super.returnEnemySurvivor().hitC4();
          super.returnEnemySurvivor().lostgame();
          }
       } // the hitC4 code is unique to the C4 destroy method
       
   
    
    public void act() 
        {
        remove();
       }   // This spawning method is adopted from its superclass, "NonMover"
    }
     

    
    
