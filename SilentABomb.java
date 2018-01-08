import greenfoot.*; 
import java.util.List;
import java.util.ArrayList; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AtomicBomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SilentABomb extends Mover implements Destroyer
    {
    /**
     * Act - do whatever the AtomicBomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SilentABomb( int initialSpeed)
       {
       super(initialSpeed);
       }
    
    public void destroy()
       {
      if( isTouching( Survivor.class ) )
          {
           super.populateEnemySurvivor();
          super.returnEnemySurvivor().hitABomb();
          getWorld().removeObject( this );
          super.returnEnemySurvivor().lostgame();
          }
       } // the hitABomb code is unique to the SlientABomb destroy method
       
       
    public void fall()
       {
       setLocation( getX() , getY() + getSpeed() );
       if( getY() == 380 )
          {
          getWorld().removeObject(this);
          }
       } // This allows the bombs to only move down the y-axis, and eventually go away if it reaches the bottom of the world
       
    public void act() 
       {
       fall();
       }    
    }
