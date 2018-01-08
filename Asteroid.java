import greenfoot.*;
import java.util.List;
import java.util.ArrayList;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Mover implements Destroyer
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Asteroid()
       {
       super();
       }
      
    public Asteroid(int initialSpeed )
       {
       super( initialSpeed);
       }
       
    public void destroy()
       {
      if( isTouching( Survivor.class ) )
          {
           super.populateEnemySurvivor();
          super.returnEnemySurvivor().hitAsteroid();
          getWorld().removeObject( this );
          super.returnEnemySurvivor().lostgame();

          }
       }// the hitAsteroid code is unique to the Asteroid destroy method
       
     
       
    public void spin()
       {
       if( isAtEdge() ) 
          {
          turn( 180 ) ;
          } 
       move( getSpeed() );
       turn(  Greenfoot.getRandomNumber(2) );
       } // This ensures that the asteroids move circularly and bounces off the edge of the World
       
    public void act() 
       {
       spin();
       }    
}
