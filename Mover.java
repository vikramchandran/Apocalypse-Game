import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mover extends Enemy implements Destroyer
{
    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    

    public Mover()
       {
       super();
       speed = 0;
       }
    
    public Mover( int initialspeed)
       {
       super();
       speed = initialspeed;
       }
       
    
    public int getSpeed()
       {
       return speed;
       }
     
    public void setSpeed(int newSpeed)
       {
       speed = newSpeed;
       }
     
    public abstract void destroy();
 
}
