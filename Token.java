import greenfoot.*; 
import java.util.List;
import java.util.ArrayList;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Token here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Token extends Actor
{
    /**
     * Act - do whatever the Token wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void act() 
       {
       move(2);
       turn(1);
       if( isAtEdge() )
          {
          turn(180);
          } 
       
       }  

        
    
}
