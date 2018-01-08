import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor 
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private List<Destroyer> enemies;
    private List < Survivor> survivorList;
    
    public Enemy()
       {
       enemies = new ArrayList <Destroyer>();
       survivorList = new ArrayList< Survivor > ();
       }
       
    
    public void populateEnemySurvivor()
       {
       MyWorld world = (MyWorld)getWorld();
       world.populateWorldSurvivor();
       survivorList.add( world.returnWorldSurvivor() );
       }
    
    public Survivor returnEnemySurvivor()
       {
       return survivorList.get(0);
       }
    
    public void act() 
      {
       enemies = getWorld().getObjects( Destroyer.class );
       for( Destroyer destroyer : enemies )
          {
          destroyer.destroy();
          } 
       }    // This implements class composition by combining all the "Destroyer" objects into an ArrayList. It then calls the destroy() method.
             
}
