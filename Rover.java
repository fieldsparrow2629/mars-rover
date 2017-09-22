
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
    // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=North-west
    
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }
    
    // paramaterless constructor
    public Rover()
    {
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
    
    public void rotateLeft() 
    {
        dir -= 1;
        
        if (dir < 0)
        {
            dir = 3;
        }
        
        System.out.println(name + " turned to the left");        
    }
    
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 4)
        {
            dir = 0;
        }
        
        System.out.println(name + " turned to the right");        
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + ", pics=" + numPics + "]";
    }
}
