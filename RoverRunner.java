
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover();
        Rover r3 = new Rover("Spirit");
        
        
        System.out.println(r2);
        
        System.out.println(r1);
        
        r1.setName("Bob");
        System.out.println(r1);
        
        r1.takePic();
        
        
        r3.rotateRight();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.rotateRight();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
        
        r3.move();
        System.out.println(r3);
    }
}
