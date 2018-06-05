package mazegame;

import javax.swing.*;
import java.awt.*;

public class mazegame2 {
    //Frame, labels to represent maze, class object and counter to check # of recursive calls made
    private static JFrame frame = new JFrame("Maze");
    private static JLabel[][] lbl = new JLabel[15][30];
    private static support obj = new support();
    private static int counter = 0;
    
    //Creates frame and adds labels to frame
    public static void initGUI() {
   	 frame.setBounds(0, 0, 2000, 1000);
   	 frame.setLayout(new GridLayout(15,30));
   	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   	 frame.setVisible(true);
   	 for (int row = 0; row < 15; row++) {
   		 for (int col = 0; col < 30; col++) {
   			 lbl[row][col] = new JLabel();
   			 lbl[row][col].setOpaque(true);
   			 frame.add(lbl[row][col]);
   		 }

   	 }

    }
    
    // Sets colors of labels equal to characters of maze
    public static void mazeAnimator() {

   	 for (int row = 0; row < lbl.length; row++) {

   		 for (int col = 0; col < lbl[row].length; col++) {
   			 if (obj.maze[row][col].equals("0")) {
   				 lbl[row][col].setBackground(Color.black);
   			 }
   			 else if (obj.maze[row][col].equals("$")) {
   				 lbl[row][col].setBackground(Color.green);
   				 lbl[row][col].setFont(new Font("Comic Sans MS", Font.BOLD, 25));
   				 lbl[row][col].setText("END");
   			 }
   			 else if (obj.maze[row][col].equals("=")) {
   				 lbl[row][col].setBackground(Color.white);
   			 }
   			 else if (obj.maze[row][col].equals("S")) {
   				 lbl[row][col].setBackground(Color.cyan);
   				 lbl[row][col].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
   				 lbl[row][col].setText("START");
   			 }
   		 }
   	 }
   	 System.out.println("Maze made successfully.");
    }

    //recursive function that solves text maze
    private static boolean mazeSolver(int x, int y) {

   	 counter++;
   	 // end condition
   	 if (obj.maze[x][y].equals("$")) {
   		 return true;
   	 }
   	 // impassable objects
   	 if (obj.maze[x][y].equals("0") || obj.maze[x][y].equals("*")) {
   		 return false;
   	 }
   	 // add delay to illustrate movement
   	 try {
   		 Thread.sleep(100);
   	 } catch (InterruptedException e) {
   		 System.out.println("got interrupted");
   	 }
   	 // mark this location
   	 obj.maze[x][y] = "*";
   	 lbl[x][y].setBackground(Color.orange);
   	 boolean result;

   	 result = mazeSolver(x - 1, y); // tries to go up
   	 if (result) {
   		 return true;
   	 }

   	 result = mazeSolver(x + 1, y); // tries to down
   	 if (result) {
   		 return true;
   	 }
   	 result = mazeSolver(x, y + 1); // tries to go right
   	 if (result) {
   		 return true;
   	 }
   	 result = mazeSolver(x, y - 1); // tries to go left
   	 if (result) {
   		 return true;
   	 }
   	 // add delay to illustrate movement
   	 try {
   		 Thread.sleep(100);
   	 } catch (InterruptedException e) {
   		 System.out.println("got interrupted");
   	 }
   	 // dead end
   	 obj.maze[x][y].equals("-");
   	 lbl[x][y].setBackground(Color.red);
   	 Toolkit.getDefaultToolkit().beep();
   	 // go back
   	 return false;
    }

    public static void main(String[] args) {
   	 //
   	 initGUI();
   	 obj.openFile();
   	 obj.readFile();
   	 obj.closeFile();
   	 mazeAnimator();

   	 // start from (13,2)
   	 mazeSolver(13,2);
   	 JOptionPane.showMessageDialog(null, "# of Calls: " + counter);

    }
}

