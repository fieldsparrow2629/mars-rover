
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
    int health;
    int x;
    int y;
    int dir;
    String face; 
    int numPics;
    boolean isAlive;
    int energy;
    int dmg;
    
    // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=North-west
    
    
    /**
     * takes a name and constructs a rover object for it
     *
     * @param name name of the rover
     */ 
    public Rover(String name)
    {
        this.health = 15;
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.energy = 50;
        this.face = "North";
        this.isAlive = true;
        this.dmg = 5;
    }
    
    /**
     * constructs a rover object but without taking in a name
     *
     * 
     */ 
    public Rover()
    {
        this.health = 15;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.energy = 50;
        this.face = "North";
        this.isAlive = true;
        this.dmg = 5;
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
     */ 
    public void takePic()
    {   
        getDirectionName(dir);
        
        if(this.numPics >= 6)
        {
            System.out.println("Error:Memory full");
        }
        
        else{
            this.numPics = this.numPics + 1;
            System.out.println(name + " took a " + this.face + " facing picture at [" + x + "," + y +"]");
        }
    }
    
    /**
     * takes a picture, increases num of pics by 1, displays location 
     *
     */ 
    public void transmitPictures()
    {
       System.out.println("The rover sends the pictures back to earth.");
       System.out.println(name + " now has zero pictures stored.");
       this.numPics = 0;
    }
    
    /**
     * takes a selfie, says location, increase # of pics
     * requires 1 energy
     *
     */ 
     public void selfie()
    {
        getDirectionName(dir);
        
        if(this.energy > 0){
            if(this.numPics > 2)
            {
                System.out.println("Error:Memory full");
            }
            else{
                this.numPics += 1;
                System.out.println(name + " took a " + this.face + " facing selfie at [" + x + "," + y +"]");
            }
            this.energy -= 1;
        }
        
        else{
            System.out.println("Error:Not enough energy.");
        }
    }
    

    /**
     * moves the rover based off its direction it has stored
     * requires 1 energy per move
     * creates a loop, running as many times as the # of moves
     *
     * @param numTimes the number of moves the rover will make
     * in that direction
     */ 
    public void move(int numTimes)
    {
        int moves = numTimes;
        if(isAlive)
        
        {
            while(numTimes > 0 && energy > 0){
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
                energy -= 1;
                numTimes -= 1;
            }
            System.out.println(name + " moved in direction " + dir +"," + moves + " times.");
        }
        
        if(this.energy == 0){
            System.out.print("Error:Energy depleted.");
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
            face = "North";
        }
        else if (dir == 1){
            face = "North-East";    
        }
        else if (dir == 2){
            face = "East";    
        }
        else if (dir == 3){
            face = "South-East";    
        }
        else if (dir == 4){
            face = "South";    
        }
        else if (dir == 5){
            face = "South-West";    
        }
        else if (dir == 6){
            face = "West";    
        }
        else{
            face = "North-West";   
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
        
        String whichWay = "null";
        int count = turns;
        while(turns != 0 && energy > 0){
            
            if(turns < 0){
                dir -= 1;
                turns += 1;
                whichWay = "left";
            }
            else{
                dir += 1;
                turns -= 1;
                whichWay = "right";
            }
            
            if (dir < 0)
            {
                dir = 7;
            }
            else if(dir == 8)
            {
                dir = 0;
            }
            
            this.energy -= 1;
        }    
        
        if(this.energy == 0){
            System.out.println("Error: Energy depleted.");
        }
        
        System.out.println(name + " turned to the " + whichWay + ", " + count + " times."); 
        getDirectionName(dir);
    }
    
    /**
     * teleports the rover to a given x and y coordinate
     * requires 5 energy
     * 
     * @param int x x coordinate
     * @param in y y coordinate
     * 
     */ 
    public void teleport(int x, int y)
    {
        if(this.isAlive){
            if(this.energy >= 5){
                this.x = x;
                this.y = y;
                System.out.println(name + " teleports to [" + x + "," + y + "].");
                this.energy -= 5;
            }
            else{
                System.out.println("Error:Not enough energy.");
            }
        }
        else{
            System.out.println(this.name + " is dead.");
        }
    }
    
    /**
     * replenishes the rovers energy based off of the input int
     * max energy is 50
     *
     * @param amnt the amount of energy thats restored
     */ 
    public void restore(int amnt)
    {
        if(this.energy + amnt >= 50){
            this.energy = 50;
        }
        else{
            this.energy += amnt;
        }
        System.out.println(this.name + " charged to " + this.energy + " units of energy.");
    }
    
    /**
     * makes one rover attack another, based off of dmg 
     * and health fields
     *
     * @param enemy the enemy rover who is being attacked
     */ 
    public void attack(Rover enemy)
    {
        System.out.println(this.name + " attacks " + enemy.name + "...");
        
        if(enemy.health == 0){
            System.out.println(enemy.name + " is already dead.");
        }
        
        enemy.health -= this.dmg;
        if(enemy.isAlive){
            if(enemy.health <= 0){
                System.out.println(this.name + " kills " + enemy.name + ".");
                enemy.isAlive = false;
            }
            else{
                System.out.println(this.name + " deals " + this.dmg + " damage to " + enemy.name + ".");
            }
        }
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * displays the fields that the object rover contains
     *
     * 
     */ 
    public String toString()
    {
        return "Rover[name=" + name + ", health=" + health + ", alive=" + isAlive + ", x=" + x + ", y=" + y + ", dir=" + dir + ", face=" + face + ", pics=" + numPics + ", energy=" + energy + "]";
    }
}