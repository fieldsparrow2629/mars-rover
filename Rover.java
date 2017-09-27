
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
    String face; 
    int numPics;
    boolean isAlive;
    // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=North-west
    
    
    /**
     * takes a name and constructs a rover object for it
     *
     * @param name name of the rover
     */ 
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.face = "North";
        this.isAlive = true;
    }
    
    /**
     * constructs a rover object but without taking in a name
     *
     * 
     */ 
    public Rover()
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.face = "North";
        this.isAlive = true;
    }
    
    /**
     * allows you to change the namge of a rover
     *
     * @param name name you want to change the rover to
     */ 
    public void setName(String name)
    {
       this.name = name;
    }
    
    /**
     * takes a picture, increases num of pics by 1, displays location 
     *
     * 
     */ 
    public void takePic()
    {   
        getDirectionName(dir);        
        this.numPics = this.numPics + 1;
        System.out.println(name + " took a " + this.face + " facing picture at [" + x + "," + y +"]");
    }
    
    /**
     * takes a selfie, says location, increase # of pics
     *
     * @param 
     */ 
     public void selfie()
    {
        getDirectionName(dir);
        this.numPics += 1;
        System.out.println(name + " took a " + this.face + " facing selfie at [" + x + "," + y +"]"); 
    }

    /**
     * moves the rover based off its direction it has stored
     *
     * @param numTimes the number of moves the rover will make
     * in that direction
     */ 
    public void move(int numTimes)
    {
        if(isAlive)
        {
            if (dir == 0)
            {
                y += numTimes;
            }
            else if (dir == 1)
            {
                x += numTimes;
                y += numTimes;
            }
            else if (dir == 2)
            {
                x += numTimes;
            }
            else if (dir == 3) 
            {
                x += numTimes;
                y -= numTimes;
            }
            else if (dir ==4) 
            {
                y -= numTimes;
            }
            else if (dir == 5) 
            {
                x -= numTimes;
                y -= numTimes;
            }
            else if (dir == 6) 
            {
                x -= numTimes;
            }
            else if (dir == 7) 
            {
                x -= numTimes;
                y += numTimes;
            }
            
            System.out.println(name + " moved in direction " + dir);
        }
        else
        {
            System.out.println(name + " is dead.");
        }
            
    }
    
    /**
     * changes the direction from an int to its corresponding
     * string name
     *
     * @param dir the direction: stored as an int value
     */ 
    private void getDirectionName(int dir)
    {
        String face = "null";
        if (dir == 0){
            this.face = "North";
        }
        else if (dir == 1){
            this.face = "North-East";    
        }
        else if (dir == 2){
            this.face = "East";    
        }
        else if (dir == 3){
            this.face = "South-East";    
        }
        else if (dir == 4){
            this.face = "South";    
        }
        else if (dir == 5){
            this.face = "South-West";    
        }
        else if (dir == 6){
            this.face = "West";    
        }
        else{
            this.face = "North-West";   
        }

    }
    
    /**
     * rotates the rover 
     * based off the given in value
     *
     * @param turns the number of turns it makes in a left
     * or right, negative is left, positive is the the right
     */ 
    public void rotate(int turns) 
    {
        dir += turns;
        
        String way = "null";
        if (dir < 0)
        {
            dir = 7;
        }
        else if(dir == 8)
        {
            dir = 0;
        }
        
        if(turns < 0)
        {
            way = "left";
        }
        
        else{
            way = "right";
        }
        System.out.println(name + " turned to the " + way + ", " +turns + " times.");        
    }
    
    /**
     * kills another rover
     * (prevents that rover from doing actions)
     *
     * @param enemy the enemy rover that will be killed
     */ 
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
    
    /**
     * displays the fields that the object rover contains
     *
     * 
     */ 
    public String toString()
    {
        return "Rover[name=" + name + ", alive=" + isAlive + ", x=" + x + ", y=" + y + ", dir=" + dir + ", face=" + face + ", pics=" + numPics + "]";
    }
}
