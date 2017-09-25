
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    // fields
    String name;
    int x;
    int y;
    int dir; 
    int numPics;
    boolean isAlive;
    // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=North-west
    
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.isAlive = true;
    }
    
    // paramaterless constructor
    public Rover()
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.isAlive = true;
    }
    
    public void takePic()
    {   
      
        this.numPics = this.numPics + 1;
        System.out.println(name + " took a picture at [" + x + "," + y +"]");
    }
    
    public void setName(String name)
    {
       this.name = name;
    }
    
    // methods - stuff the Rover can do
    public void move()
    {
        if(isAlive)
        {
            if (dir == 0)
            {
                y += 1;
            }
            else if (dir == 1)
            {
                x += 1;
                y += 1;
            }
            else if (dir == 2)
            {
                x += 1;
            }
            else if (dir == 3) 
            {
                x += 1;
                y -= 1;
            }
            else if (dir ==4) 
            {
                y -= 1;
            }
            else if (dir == 5) 
            {
                x -= 1;
                y -= 1;
            }
            else if (dir == 6) 
            {
                x -= 1;
            }
            else if (dir == 7) 
            {
                x -= 1;
                y += 1;
            }
            
            System.out.println(name + " moved in direction " + dir);
        }
        else
        {
            System.out.println(name + " is dead.");
        }
            
    }
    
    public void rotateLeft() 
    {
        dir -= 1;
        
        if (dir < 0)
        {
            dir = 7;
        }
        
        System.out.println(name + " turned to the left");        
    }
    
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 8)
        {
            dir = 0;
        }
        
        System.out.println(name + " turned to the right");        
    }
    
    public void kill(Rover enemy)
    {
        if(Math.abs(this.x - enemy.x) <= 1 && Math.abs(this.y - enemy.y) <= 1)
        {
            System.out.println(this.name + " kills " + enemy.name);
            enemy.isAlive = false;
        }
        else
        {
            System.out.println(this.name + " not close enough to kill " + enemy.name);
        }
    }
    
    public String toString() 
    {
        return "Rover[name=" + name + ", alive=" + isAlive + ", x=" + x + ", y=" + y + ", dir=" + dir + ", pics=" + numPics + "]";
    }
}
