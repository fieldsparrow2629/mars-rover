
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
        Rover r2 = new Rover("Curiosity");
        Rover r3 = new Rover("Spirit");

        System.out.println(r2);
        r2.takePic();
        r2.move(15);
        System.out.println(r2);
        r2.rotate(-50);
        System.out.println(r2);
        r2.move(50);
        
        r2.restore(10);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r3.move(4);
        r3.move(4);
        r3.move(4);
        r3.move(4);
        
  
    }
}
