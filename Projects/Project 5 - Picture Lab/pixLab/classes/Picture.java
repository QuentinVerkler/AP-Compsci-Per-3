import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.print(count);
    //18410
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  //myCollage methods
  public void myCopy(Picture fromPic, int startRow, int startCol, int endRow, int endCol){
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for(int fromRow = 0, toRow = startRow; fromRow < endRow && toRow < toPixels.length;
          fromRow++, toRow++){
            for(int fromCol = 0, toCol = startCol; fromCol < endCol && toCol < toPixels[0].length;
               fromCol++, toCol++){
                 fromPixel = fromPixels[fromRow][fromCol];
                 toPixel = toPixels[toRow][toCol];
                 toPixel.setColor(fromPixel.getColor());
              }
          }
    }
    
  public void createMyCollage(){
    Picture commandos = new Picture("CloneCommandos.jpg");
    Picture droids = new Picture("droids.jpg");
    this.myCopy(commandos, 843, 214, 98, 223);
    Picture commandosOnlyBlue = new Picture("CloneCommandos.jpg");
    commandosOnlyBlue.keepOnlyBlue();
    this.myCopy(commandosOnlyBlue, 1000, 130, 98, 223);
    droids.negate();
    this.myCopy(droids, 0, 0, 680, 567);
    this.write("myCollage.jpg");
  }
    

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist, Picture thatPic)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Pixel[][] copyPixels = thatPic.getPixels2D();
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
        
      }
    }
    //top to bottom 
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Color bottomColor = null;
    Pixel destinationTopPixel = null;
    for(int row = 0; row < copyPixels.length-1; row++){
        for(int col = 0; col < copyPixels[row].length; col++){
            topPixel = copyPixels[row][col];
            bottomPixel = copyPixels[row+1][col];
            bottomColor = bottomPixel.getColor();
            destinationTopPixel = pixels[row][col];
            if (topPixel.colorDistance(bottomColor) > edgeDist){
                destinationTopPixel.setColor(Color.BLACK);
            }else{
                destinationTopPixel.setColor(Color.WHITE);
            }
        }
    }
  }
  
  //Change line color method
  public void changingLineColor(){
      Pixel pixel = null;
      Pixel[][] pixels = this.getPixels2D();
      for(int r = 0; r < pixels.length; r++){
          for(int c = 0; c < pixels[r].length; c++){
              Color pixelColor = pixels[r][c].getColor();
              //System.out.println("Color: " + pixelColor + " " + Color.BLACK);
              if(pixelColor.equals(Color.BLACK)){
                  int random = (int)(Math.random()*4);
                  if(random == 0){
                      pixels[r][c].setColor(Color.YELLOW);
                    } else if(random == 1){
                      pixels[r][c].setColor(Color.RED);
                    }else if(random == 2){
                      pixels[r][c].setColor(Color.GREEN);
                    }else if(random == 3){
                      pixels[r][c].setColor(Color.BLUE);
                    }
                } else{
                    pixels[r][c].setColor(Color.BLACK);
                }
            }
        }
    }
  
  //keepOnlyBlue method
  public void keepOnlyBlue(){
      Pixel[][] pixels = this.getPixels2D();
      for(int r = 0; r < pixels.length; r++){
          for(int c = 0; c < pixels[r].length; c++){
              pixels[r][c].setRed(0);
              pixels[r][c].setGreen(0);
            }
        }
    }
    
  //negate method
  public void negate(){
      Pixel[][] pixels = this.getPixels2D();
      for(int r = 0; r < pixels.length; r++){
          for(int c = 0; c < pixels[r].length; c++){
              int red = 255 - pixels[r][c].getRed();
              pixels[r][c].setRed(red);
              pixels[r][c].setGreen(255 - pixels[r][c].getGreen());
              pixels[r][c].setBlue(255 - pixels[r][c].getBlue());
            }
        }
    }
  
  //grayScale method
  public void grayScale(){
      Pixel[][] pixels = this.getPixels2D();
      for(int r = 0; r < pixels.length; r++){
          for(int c = 0; c < pixels[r].length; c++){
              int average = (pixels[r][c].getRed() + pixels[r][c].getGreen() 
              + pixels[r][c].getBlue()) / 3;
              pixels[r][c].setRed(average);
              pixels[r][c].setGreen(average);
              pixels[r][c].setBlue(average);
            }
        }
    }
  
  //mirrorVerticalRighttToLeft
  public void mirrorVerticalRightToLeft(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for(int r = 0; r < pixels.length; r++){
          for(int c = 0; c < width / 2; c++){
              int away = width/2;
              rightPixel = pixels[r][width - 1 - c];
              leftPixel = pixels[r][c];
              leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
    
  //mirrorHorizontal
  public void mirrorHorizontal(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel abovePixel = null;
      Pixel belowPixel = null;
      int length = pixels.length;
      for(int r = 0; r < length / 2; r++){
          for(int c = 0; c < pixels[r].length; c++){
              abovePixel = pixels[r][c];
              belowPixel = pixels[length -1 - r][c];
              belowPixel.setColor(abovePixel.getColor());
            }
        }
    }
    
  //mirrorHorizontalBotToTop
  public void mirrorHorizontalBotToTop(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel abovePixel = null;
      Pixel belowPixel = null;
      int length = pixels.length;
      for(int r = 0; r < length / 2; r++){
          for(int c = 0; c < pixels[r].length; c++){
              abovePixel = pixels[r][c];
              belowPixel = pixels[length -1 - r][c];
              abovePixel.setColor(belowPixel.getColor());
            }
        }
    }
    
  //mirrorArms
  public void mirrorArms(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      int mirrorPoint = 196;
      for(int r = 159; r < mirrorPoint; r++){
          for(int c = 105; c < 293; c++){
              topPixel = pixels[r][c];
              bottomPixel = pixels[mirrorPoint - r + mirrorPoint][c];
              bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    
  //mirrorGulls
  public void mirrorGull(){
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int mirrorPoint = 344;
      for(int r = 234; r < 321; r++){
          for(int c = 238; c < mirrorPoint; c++){
              leftPixel = pixels[r][c];
              rightPixel = pixels[r][mirrorPoint - c + mirrorPoint];
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
