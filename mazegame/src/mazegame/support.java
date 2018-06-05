package mazegame;

import java.util.*;

import java.io.*;

public class support extends mazegame2 {
    //Scanner object to read from file and 2d string array to store maze from file.
    private Scanner reader;
    public String[][] maze = new String[15][30];
    
    //Scanner reads from file
    public void openFile() {
   	 try {
   		 reader = new Scanner(new File("C:\\Users\\s422787\\eclipse-workspace\\mazegame\\src\\Maze"));
   		 System.out.println("File successfully loaded.");
   	 } catch (Exception e) {
   		 System.out.println("Error reading file.");
   	 }
    }
    
    //Maze is copied to 2d string array
    public void readFile() {
   	 for(int row = 0; row < maze.length; row++) {
   		 for(int col = 0; col < maze[row].length; col++) {
   			 //if reader has no more lines, it stops filling the 2d array
   			 if(reader.hasNext()) {
   				 maze[row][col] = reader.next(); //fills 2d array with maze
   			 }
   		 }
   	 }
}
    //Closes scanner
    public void closeFile() {
   	 reader.close();
   	 System.out.println("Scanner closed successfully.");
    }
}


