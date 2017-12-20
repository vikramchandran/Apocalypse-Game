import greenfoot.*;
import java.util.List;
import java.util.ArrayList; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Survivor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Survivor extends Actor
{
    private int agility;
    private int numTokens;
    private double lives;

    // Find the maximum value of the Speed in the ArrayList
    
    public Survivor()
       {
       agility = 0;
       numTokens = 0;
       lives = 0.0;
       }
    
    public Survivor( int initialagility )
       {
       agility = initialagility;
       numTokens = 0; 
       lives = 10.0;
       } 
    
    public String getnumTokensasString()
       {
       return  " " + numTokens;
       }
       
    
    public String getlivesasString ()
       {
       return " " + lives;
       }
       
    public void moveSpeedbetweenObjects()
       {
       List < Asteroid > asteroidList = new ArrayList< Asteroid > ();
       asteroidList = getWorld().getObjects ( Asteroid .class );
       List < SilentABomb > abombList = new ArrayList< SilentABomb > ();
       abombList = getWorld().getObjects ( SilentABomb .class );
       List < TRex > trexList = new ArrayList < TRex > ();
       trexList = getWorld().getObjects ( TRex.class );
       if( numTokens % 5 == 0 && numTokens != 0 )
          {
          for( int index = 1 ; index < asteroidList.size() ; index++ )
             {
             asteroidList.get(index-1).setSpeed( asteroidList.get(index).getSpeed() );
             } 
          for( int index = 1 ; index < abombList.size() ; index++ )
             {
             abombList.get(index-1).setSpeed( abombList.get(index).getSpeed() );
             }
          for( int index = 1 ; index < trexList.size() ; index++ )
             {
             trexList.get(index-1).setSpeed( trexList.get(index).getSpeed() );
             }
          }
       } // I swtich the speed value from one object to another object of the same class if the player has a high number of lives and he has collected 15 tokens.
       
    
   
    public void addTokenCount(int number)
       {
       numTokens += number;
       }
    
    
    public void addLives(int number )
       {
       lives += number;
        }
    
    public int getagility()
       {
       return agility;
       }
    
    public void arrowmoving()   
       {
       if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-getagility() );
        }
        
       if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+getagility());
        }
        
       if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+getagility(), getY());
        }
        
       if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-getagility(), getY());
        }
       } // this allows for the Survivor to move using the arrow keys 
    
       
    public void hitAsteroid()
       {
       Greenfoot.playSound("Asteroid.wav" );
       List< Asteroid >  asteroidList = new ArrayList < Asteroid > ();
       asteroidList = getWorld().getObjects ( Asteroid.class );
       int counter = 0;
       for ( int index = 0 ; index < asteroidList.size() ; index ++ )
          {
          if( asteroidList.get(index).getSpeed() < 5 )
             {
             lives -=0.5;
             }
          if( asteroidList.get(index).getSpeed() > 5 )
             {
             lives -= 1; 
             }
          }
       } // This makes the Asteroid's damage to the player more severe if there are more Asteroids in the World and if the speed is higher.
    
    public void hitTRex()
       {
       Greenfoot.playSound( "TRex.wav" );
       List< TRex> trexList = new ArrayList< TRex > ();
       trexList = getWorld().getObjects ( TRex. class );
       for ( int index = 0; index < trexList.size() ; index ++ )
          {
          if( trexList.get(index).getSpeed() < 5 )
              {
              lives  -= 0.25;
              }
          if ( trexList.get(index).getSpeed() > 5 )
             {
             lives -= 0.5;
             }
          } 
       } // This makes the TRex's damage to the player more severe if there are more TRexs in the World and if the speed is higher.
    
    public void hitABomb()
       {
       List < SilentABomb > abombList = new ArrayList< SilentABomb > ();
       abombList = getWorld().getObjects( SilentABomb. class );
       for( int index = 0 ; index < abombList.size() ; index ++ )
          {
          if( abombList.get(index).getSpeed() < 5 )
             {
             lives -= 1;
             }
          if( abombList.get(index).getSpeed() > 5 )
             {
             lives -= 2;
             }
          }
       } // This makes the ABomb's damage to the player more severe if there are more ABomb's in the World and if the speed is higher.
    
    public void hitC4()
       {
       lives -= 3;
       Greenfoot.playSound("boom_x.wav" );
       }
       
    public void hitAlien()
       {
       lives -= 1;
       Greenfoot.playSound( "Alien.wav" );
       }
    
       
    public void lostgame()
       {
       if(  lives <= 0  )
          {
          Greenfoot.stop();
          getWorld().showText( "You lost!!!" , 300, 200 );
          Greenfoot.playSound( "ominous.wav" );
          }
       } // This stops the game if you have lost all your lives
    
    public void numTokensmaxed()
       {
        if( numTokens == 30 )
           {
           Greenfoot.stop();
           getWorld().showText( "You have collected enough tokens!!!" + "\n" + "You survived" , 300, 200 );
           Greenfoot.playSound( "applause_y.wav" );
           }
       } // This stops the game if you collect the max amount of tokens
    

    
    public void adjustTokenIfTouching()
       {
        if( isTouching( Token.class) )
            {
            removeTouching( Token.class) ;
            Greenfoot.playSound ( "coin-drop-1.wav" );
            numTokens += 1;
            movetokens();
            getWorld().addObject( new Token(), (int)(getWorld().getWidth()*Math.random() ), 
                                           (int)(getWorld().getHeight()*Math.random() ) );
                                           
            } 
        
       } // This removes and adds a Token if the Survivor touches a token. The count of token also increases by 1. 
    
    public void movetokens()
       {
          
          List< Token > tokenList = new ArrayList < Token > ();
          tokenList = getWorld().getObjects( Token.class );
          
       
          for( int index = 0 ; index < tokenList.size() - 1  ; index ++ )
             {
             tokenList.set( index, tokenList.get(index + 1 ) );    
             tokenList.set(index + 1 , null);
             List < Asteroid > asteroidList = new ArrayList< Asteroid > ();
             asteroidList = getWorld().getObjects ( Asteroid .class );
             List < SilentABomb > abombList = new ArrayList< SilentABomb > ();
             abombList = getWorld().getObjects ( SilentABomb .class );
             List < TRex > trexList = new ArrayList < TRex > ();
             trexList = getWorld().getObjects ( TRex.class );
             if( tokenList.get(index+1) == null )
                {
                asteroidList.get(index).setSpeed( 2 );
                trexList.get(index).setSpeed( 2 );
                abombList.get(index).setSpeed( 2 );
                }
            }  
          } // This moves the tokens within a List. If any of the tokens are equal to null, the enemy objects will slow down to a speed of 2.
       
    
    public void act() 
       {
       
       arrowmoving();
       adjustTokenIfTouching();
       numTokensmaxed();
       moveSpeedbetweenObjects();
       }  
}
    
