
/**
 * Write a description of class MazeWalker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeWalker
{
       public static void run(){
        Maze maze = new Maze();
        MazeBot mazeBot = maze.getMazeBot();
       while(mazeBot.didNotReachGoal() == true){
         if (mazeBot.canMoveForward() == true){
            mazeBot.moveForward(); 
            }
            else{
             mazeBot.turnRight();
             if (mazeBot.canMoveForward() == false){
             mazeBot.turnLeft();
             mazeBot.turnLeft();
            }
            }
        }
       
       if ( mazeBot.didReachGoal() == true){
           mazeBot.signalSuccess();
        }
        else {
            mazeBot.signalError();
        }
    }
}
