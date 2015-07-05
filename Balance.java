import java.util.*;

public class Balance{
    public static int MAXIMUM = 20;
    public static int[] BASE = baseG(MAXIMUM);//generate a base of 20 since the maximum value is 10^9
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x;
        while(true){
            x = scn.nextInt();
            String[] answer = answer(x);
            for(int i = 0; i < answer.length; i++){
                System.out.println(answer[i]);
            }
        }
    }

    public static String[] answer(int x) { 
        int length = baseLimit(x);
        String[] result = generateArray(length);
        int bLimit = -1;
        while(x != 0){
            if(x > 0){
                bLimit = baseLimit(Math.abs(x));
                x = x - p3(bLimit);
                result[bLimit] = "R";
            }
            else{
                bLimit = baseLimit(Math.abs(x));
                x = x + p3(bLimit);
                result[bLimit] = "L";
            }
        }

        return result;
    }

    //populate starting array with null
    public static String[] generateArray(int x){
        String nullx = "-";
        String[] array = new String[x + 1];

        for(int i = 0; i < x + 1; i++){
            array[i] = nullx;
        }

        return array;
    }

    //return the upperlimit of a base value
    public static int baseLimit(int x){
        for(int i = 0; i < MAXIMUM; i ++){
            if(x <= BASE[i]){
                return i;
            }
        }
        return -1;//if value exceeds 3^MAXIMUM
    }

    //Generate a baseline for the algorithm
    public static int[] baseG(int x){
        int[] array = new int[x];

        for(int i = 0; i < x; i++){
            array[i] = baseGen(i);
        }

        return array;
    }

    //Generate single base value
    public static int baseGen(int x){
        int result = 0;
        for(int i = 0; i <= x; i++){
            result = result + p3(i);
        }
        return result;
    }

    //return the power of 3
    public static int p3(int x){
        return (int)Math.pow(3, (double)x);
    }
}