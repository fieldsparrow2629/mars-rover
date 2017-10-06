
/**
 * Write a description of class inputRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class RoverRunner
{
    
    /**
     * 
     * 
     */
    public static void main(String[] args)
    {
        SimpleScanner input = new SimpleScanner();
        
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        
        boolean running = true;
        String exitCommand = "quit";
        
        while(running) {
            System.out.print("Enter the name of the Rover to act: ");
            String name = input.readString();
            
            Rover actor = group.find(name);
            
            if(actor != null) {
                System.out.print("Enter a command: ");
                String command = input.readString();
                
                if(command.equals("move")) {
                    System.out.print("Enter distance to move: ");
                    int distance = input.readInt();
                    actor.move(distance);
                    
                }
                else if(command.equals("take pic")){
                    actor.takePic();
                }
                else if(command.equals("restore")){
                    System.out.println("How much do you want to restore?");
                    int amnt = input.readInt();
                    actor.restore(amnt);
                    
                }
                else if(command.equals("teleport")){
                    System.out.println("Where do you want to teleport to?");
                    System.out.println("x = ");
                    int x = input.readInt();
                    System.out.println("y = ");
                    int y = input.readInt();
                    actor.teleport(x,y);
                }
                else if(command.equals("rotate")) {
                    System.out.print("Enter how much to rotate: ");
                    int distance = input.readInt();
                    actor.rotate(distance);
                    
                }
                else if(command.equals("attack")) {
                    System.out.print("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    
                    if(target != null) {
                        actor.attack(target);
                        System.out.println(target);
                        
                    }
                    else {
                        System.out.println("Error: no such target.");
                    }
                }
                else {
                    System.out.println("Error: Invalid command.");
                    
                }
                
                System.out.println(actor);
            }
                
            else if(name.equals(exitCommand)){
                running = false;
            }
            
            else{
                System.out.println("Error: " + name + " doesn't exist.");
            }
            
            System.out.println();
            
        }
                
            
        System.out.println("Goodbye.");
    }
}

