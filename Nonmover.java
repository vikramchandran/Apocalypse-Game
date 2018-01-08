import greenfoot.*; 
import java.util.List;
import java.util.ArrayList; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NonMover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NonMover extends Enemy implements Destroyer
   {
    /**
     * Act - do whatever the NonMover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private List < NonMover > nonmoverlist;
   
    public NonMover()
       {
       super();
       }
    
    public void remove()
       {
       int counter = 0;
       int index = 0;
       nonmoverlist = new ArrayList<NonMover> ();
       nonmoverlist = getWorld().getObjects(NonMover.class);
       while( index < nonmoverlist.size() )
          {
          counter++;
          index++;
          }
       if(counter > 6 )
          {
          getWorld().removeObject( this );
          }
       } // This is a unique method not used in the Mover superclass. I "count" the number of NonMover's in a list, and remove the NonMover if there are too many.
       // I didn't include addObject here because that was dependent on the timer, which is a private instance variable from MyWorld. 
    
    public abstract void destroy();

   }
