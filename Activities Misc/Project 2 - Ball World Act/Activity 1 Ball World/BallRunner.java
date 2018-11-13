
/**
 * Write a description of class BallRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BallRunner
{
    public static void run(){
     BallWorld ballWorld = new BallWorld(200, 200);   
     BallBot ballBot = new BallBot(ballWorld, new TGPoint(0.0, 0.0), 90.0, 30);
     int x = 0;
     while(x == 0){
        if(ballBot.canMoveForward(ballWorld) == true){
        ballBot.moveForward();
    }
        else{
            double startheading = ballBot.getHeading();
            ballBot.setHeading(startheading + 90.0);
            if( startheading + 90.0 % 90.0 >= 4.0){
            startheading = startheading - 360.0;
            ballBot.setHeading(startheading);
            }
        }
        
        }
    }
}
