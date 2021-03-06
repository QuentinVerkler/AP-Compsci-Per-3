/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester 
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("explosion.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("me.jpg");
    Picture swan1 = new Picture("me.jpg");
    swan.edgeDetection(10, swan1);
    swan.changingLineColor();
    swan.explore();
    swan.write("colorMe.jpg");
  }
  
  public static void testKeepOnlyBlue(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
    }
  
  public static void testNegate(){
      Picture beach = new Picture("explosion.jpg");
      beach.explore();
      beach.negate();
      beach.explore();
    }
    
  public static void testGrayscale(){
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.grayScale();
      beach.explore();
    }
    
  public static void testMirrorVerticalRightToLeft(){
      Picture caterpillar = new Picture("explosion.jpg");
      caterpillar.explore();
      caterpillar.mirrorVerticalRightToLeft();
      caterpillar.explore();
    }
    
  public static void testMirrorHorizontal(){
      Picture explosion = new Picture("explosion.jpg");
      explosion.explore();
      explosion.mirrorHorizontal();
      explosion.explore();
    }
    
  public static void testMirrorHorizontalBotToTop(){
      Picture explosion = new Picture("explosion.jpg");
      explosion.explore();
      explosion.mirrorHorizontalBotToTop();
      explosion.explore();
    }
    
  public static void testMirrorArms(){
      Picture snowman = new Picture("snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
    }
    
  public static void testMirrorGull(){
      Picture gull = new Picture("seagull.jpg");
      gull.explore();
      gull.mirrorGull();
      gull.explore();
    }
    
  public static void testMyCollage(){
      Picture commandos = new Picture("CloneCommandos.jpg");
      Picture droids = new Picture("droids.jpg");
      Picture rock = new Picture("StarWarsRock.jpg");
      rock.createMyCollage();
      rock.explore();
      //commandos.explore();
      //droids.explore();
    }
    
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMyCollage();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}