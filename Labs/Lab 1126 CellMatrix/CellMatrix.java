 
/**
 * 
 * CellMatrix
 * @author (eettlin) 
 * @version (11-26-18)
 */
public class CellMatrix{
    /**
     * +++++++++++++++++++++Instance variables
     */
    
    private Cell[][] cells;

    /**
     * +++++++++++++++++++++Constructor for objects of class NumberMatrix
     */
    public CellMatrix(int a, int b){
       cells = new Cell[a][b];
       
    }

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++methods
     */
    //Print each row and column of nums to the console
    public void printMatrix(){
       for(int r = 0; r < cells.length; r++){
           for(int c = 0; c < cells[r].length; c++){
               System.out.print(cells[r][c].getInt() + " | ");
            }
            System.out.println();
        }
    }
    //  load nums with random with numbers between 1 and 10 inclusive
    public void loadMatrix(){
       for(int r = 0; r < cells.length; r++){
           for(int c = 0; c < cells[r].length; c++){
               int random = (int)(Math.random() * 10) + 1;
               cells[r][c] = new Cell(random);
            }
        }
    }
    
    //  Load neighbor cells into the neighbors array
    public void loadNeighbors(){
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[r].length; c++){
                Cell[] neighbors = cells[r][c].getNeighbors();
                if(r == 0 && c == 0){
                    neighbors[1] = cells[r][c+1];
                    neighbors[2] = cells[r+1][c];
                }else if(r == 0 && c == 3){
                    neighbors[2] = cells[r+1][c];
                    neighbors[3] = cells[r][c-1];
                }else if(r == 0 && c != 3){
                    neighbors[1] = cells[r][c+1];
                    neighbors[2] = cells[r+1][c];
                    neighbors[3] = cells[r][c-1];
                }else if(r != 2 && c == 0){
                    neighbors[0] = cells[r-1][c];
                    neighbors[1] = cells[r][c+1];
                    neighbors[2] = cells[r+1][c];
                }else if(r == 2 && c == 0){
                    neighbors[0] = cells[r-1][c];
                    neighbors[1] = cells[r][c+1];
                }else if(r == 2 && c == 3){
                    neighbors[0] = cells[r-1][c];
                    neighbors[3] = cells[r][c-1];
                }else if(r == 2 && c != 0){
                    neighbors[0] = cells[r-1][c];
                    neighbors[1] = cells[r][c+1];
                    neighbors[3] = cells[r][c-1];
                }else if(r != 0 && c == 3){
                    neighbors[0] = cells[r-1][c];
                    neighbors[2] = cells[r+1][c];
                    neighbors[3] = cells[r][c-1];
                }else{
                    neighbors[0] = cells[r-1][c];
                    neighbors[1] = cells[r][c+1];
                    neighbors[2] = cells[r+1][c];
                    neighbors[3] = cells[r][c-1];
                }
            }
        }
    }
    
    //  Findis the sum of each of the neighbors and returns the greatest 
    // neighbor value
    public int getGreatestNeighbors(){
        int greatest = 0;
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[r].length; c++){
                int total = 0;
                Cell[] neighbors = cells[r][c].getNeighbors();
                if(r == 0 && c == 0){
                    total = neighbors[1].getInt() + neighbors[2].getInt();
                }else if(r == 0 && c == 3){
                    total = neighbors[2].getInt() + neighbors[3].getInt();
                }else if(r == 0 && c != 3){
                    total = neighbors[1].getInt() + neighbors[2].getInt() + neighbors[3].getInt();
                }else if(r != 2 && r != 0 && c == 0){
                    total = neighbors[0].getInt() + neighbors[2].getInt() + neighbors[1].getInt();
                }else if(r == 2 && c == 0){
                    total = neighbors[0].getInt() + neighbors[1].getInt();
                }else if(r == 2 && c == 3){
                    total = neighbors[0].getInt() + neighbors[3].getInt();
                }else if(r == 2 && c != 0){
                    total = neighbors[0].getInt() + neighbors[1].getInt() + neighbors[3].getInt();
                }else if(r != 0 && c == 3){
                    total = neighbors[0].getInt() + neighbors[2].getInt() + neighbors[3].getInt();
                }else{
                    total = neighbors[0].getInt() + neighbors[1].getInt() + neighbors[2].getInt()
                    + neighbors[3].getInt();
                }
                if(greatest < total){
                    greatest = total;
                }
            }
        }
        return greatest;
    }
    
    
}
