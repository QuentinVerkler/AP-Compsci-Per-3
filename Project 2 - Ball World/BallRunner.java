
/**
 * Write a description of class BallRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BallRunner
{
    public static void activity1(){
     BallWorld ballWorld = new BallWorld(200, 200);   
     BallBot ballBot = new BallBot(ballWorld, new TGPoint(0.0, 0.0), 90.0, 30);
     while(true){
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
    
    //checks if any indexes of an array are empty
    public int findFreeBallBotIndex(BallBot[] ballBotArray){
        int ballArray = ballBotArray.length;
        for(int i = 0; i<ballBotArray.length; i++){
            if(ballBotArray[i] == null){
             ballArray = i;  
            }
        }
        return ballArray;
    }
            
    public static void activity2(){
     BallWorld ballWorld = new BallWorld(200, 200); 
     TGPoint entryPoint = new TGPoint(0.0, 0.0);
     BallBot[] ballBotArray = new BallBot[10];
     BallRunner ballRunner = new BallRunner();
     while(true){
         //first checks if an index is empty
         int freeindex = ballRunner.findFreeBallBotIndex(ballBotArray);
         //if an index is empty, then it will fill the index with a new ballBot object
         if(freeindex < ballBotArray.length){
             
             ballBotArray[freeindex] = new BallBot(ballWorld, entryPoint, (int)(Math.random())*360, 20);
            }
         for( int index = 0; index < ballBotArray.length; index++){
             if(ballBotArray[index] != null){
                     if(ballBotArray[index].canMoveForward(ballWorld) == true){
                         ballBotArray[index].moveForward();
                        }
                        else{
                            ballBotArray[index].setHeading(Math.random() *360);
                        }
                }
            }
        }
    }
    
    //Finds the distance between points
    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double distance = Math.sqrt(Math.pow(point1.x - point2.x , 2) + Math.pow(point1.y - point2.y , 2));
        return distance;
    }
    
    //checks if an entrance is clear of any ball bots
    public boolean entranceClear(BallBot[] ballBotArray, TGPoint entrancePoint){
        BallRunner ballRunner = new BallRunner();
        boolean question = true;
        for(int i = 0; i < ballBotArray.length; i++){
            if(ballBotArray[i] != null){
                if(ballRunner.distanceBetweenPoints(entrancePoint, ballBotArray[i].getPoint()) < ballBotArray[i].getRadius() * 2){
                    return false;
                }
            }
        }
        return question;
    }
    
    public static void activity3(){
        BallWorld ballWorld = new BallWorld(200, 200);
        TGPoint entryPoint = new TGPoint(0.0, 0.0);
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballRunner = new BallRunner();
        while(true){
            int x = (int)(Math.random()*20)+1;
            //first checks if entrance is clear
                if(ballRunner.entranceClear(ballBotArray, entryPoint) == true){
                    int freeindex = ballRunner.findFreeBallBotIndex(ballBotArray);
                    //if the entrance is clear, I want to see if a new ballBot is needed.
                    //if a ballBot is needed, it is created in the array
                    if(freeindex < ballBotArray.length){
                        ballBotArray[freeindex] = new BallBot(ballWorld, entryPoint, (int)(Math.random()*360), x);
                    }
                }
                //How balls move around
                        for(int index = 0; index < ballBotArray.length; index++){
                            if(ballBotArray[index] != null){
                                if(ballBotArray[index].canMoveForward(ballWorld) == true){
                                    ballBotArray[index].moveForward();
                                }
                                else{
                                    ballBotArray[index].setHeading(Math.random() * 360);
                                }
                            }
                        }
                }
            }
    
    //method to make a ball bounce if touching another ball
    public BallBot ballBotToBounceOff(BallBot ballBot, BallBot[] ballBotArray){
        //naming 2 variables, one is where the point is. The other one is where it will move forward
        TGPoint firstPoint = ballBot.getPoint();
        TGPoint nextPoint = ballBot.forwardPoint();
        BallRunner ballRunner = new BallRunner();
        for(int i = 0; i < ballBotArray.length; i++){
            BallBot otherBallBot = ballBotArray[i];
            //checks if otherBallBot is null or not equal to ballBot parameter.
            //if either true, returns null
            if(otherBallBot != null & otherBallBot != ballBot){
                double currentDistance = ballRunner.distanceBetweenPoints(ballBot.getPoint(), otherBallBot.getPoint());
                //if the current distance between the two balls is less then their radii combined
                //then stop. Else, go to next condition
                if(currentDistance <= ballBot.getRadius() + otherBallBot.getRadius()){
                    double nextDistance = ballRunner.distanceBetweenPoints(nextPoint, otherBallBot.getPoint());
                    //if the next distance it will be at is less or equal to currentDistance
                    //the ballBot bounce off
                    if(nextDistance <= currentDistance){
                        return otherBallBot;
                    }
                }
            }
        }
        return null;
        
    }
    
    //run method activity 4
    public static void activity4(){
        BallWorld ballWorld = new BallWorld(600, 600);
        TGPoint entryPoint = new TGPoint(0.0, 0.0);
        BallBot[] ballBotArray = new BallBot[10];
        BallRunner ballRunner = new BallRunner();
        while(true){
            int r = (int)(Math.random()*20)+1;
            //checks if entry clear
            if(ballRunner.entranceClear(ballBotArray, entryPoint) == true){
                int freeIndex = ballRunner.findFreeBallBotIndex(ballBotArray);
                if(freeIndex < ballBotArray.length){
                    ballBotArray[freeIndex] = new BallBot(ballWorld, entryPoint, (int)(Math.random()*360), r);
                }
            }
            //how balls move
            for(int i = 0; i < ballBotArray.length; i++){
                if(ballBotArray[i] != null){
                    if(ballBotArray[i].canMoveForward(ballWorld) == true){
                        if(ballRunner.ballBotToBounceOff(ballBotArray[i], ballBotArray) == null){
                            ballBotArray[i].moveForward();
                        }
                        else{
                            ballBotArray[i].setHeading(360.0*Math.random());
                        }
                    }
                    else{
                        ballBotArray[i].setHeading(360.0*Math.random());
                    }
                }
            }
        }
    }
    
}
