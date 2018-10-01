
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
         int freeindex = ballRunner.findFreeBallBotIndex(ballBotArray);
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
    
    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double distance = Math.sqrt(Math.pow(point1.x - point2.x , 2) + Math.pow(point1.y - point2.y , 2));
        return distance;
    }
    
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
                if(ballRunner.entranceClear(ballBotArray, entryPoint) == true){
                    int freeindex = ballRunner.findFreeBallBotIndex(ballBotArray);
                    if(freeindex < ballBotArray.length){
                        ballBotArray[freeindex] = new BallBot(ballWorld, entryPoint, (int)(Math.random()*360), x);
                    }
                }
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
    
    public BallBot ballBotToBounceOff(BallBot ballBot, BallBot[] ballBotArray){
        
    }
    
        }
