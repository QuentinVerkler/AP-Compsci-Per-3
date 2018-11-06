
/**
 * Write a description of class ArrayRunner here.
 *
 * @ Quentin Verkler
 * @ 1106 */
public class ArrayRunner
{
    public static void main(){
        int[][] box = new int[10][10];
        loadArray(box);
        System.out.println(sumAll(box));
        System.out.println(findGreatest(box));
        System.out.println(numberOfGreatest(box));
        System.out.println(findAvg(box));
    }
    public static void loadArray(int[][] nums){
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                nums[r][c] = (int)(Math.random() * 100) + 1;
            }
        }
    }
    public static int sumAll(int[][] nums){
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                sum += nums[r][c];
            }
        }
        return sum;
    }
    public static int findGreatest(int[][] nums){
        int max = 0;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                if(nums[r][c] > max){
                    max = nums[r][c];
                }
            }
        }
        return max;
    }
    public static int numberOfGreatest(int[][] nums){
        int max = findGreatest(nums);
        int average = 0;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                if(nums[r][c] == max){
                    average++;
                }
            }
        }
        return average;
    }
    public static double findAvg(int[][] nums){
        int sum = 0;
        int total = nums.length * nums[0].length;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                sum += nums[r][c];
            }
        }
        double average = ((double)sum)/total;
        return average;
    }
}
