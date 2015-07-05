import java.util.*;

public class Square{    
    public static int MAXIMUM = 10000;
    public static int[] squareArray = squares((int)Math.sqrt(MAXIMUM));//store the perfect squares
    public static int[] storage = new int[MAXIMUM + 1];//store for future reference
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x;
        while(true){
            x = scn.nextInt();
            System.out.println(x + "=" + answer(x));
        }
    }

    public static int answer(int n) { 
        int result = -1;
        
        if(storage[n] != 0){
            return storage[n];
        }
        else if(powerCheck(n)){
            storage[n] = 1;
            return 1;
        }
        
        for(int i = 1; i <= n/2; i++){
            if(result == -1){
                result = answer(i) + answer(n - i);
                if(result == 2){
                    storage[n] = result;
                    return result;
                }
            }
            else{
                result = Math.min(result, answer(i) + answer(n - i));
                if(result == 2){
                    storage[n] = result;
                    return result;
                }
            }
        }
        
        storage[n] = result;

        return result;
    }
    
    //check if it's the power of 2
    public static boolean powerCheck(int x){
        for(int i = 0; i < Math.sqrt(x); i++){
            if(squareArray[i] == x){
                return true;
            }
        }
        return false;
    }
    
    //generate an array of squares up to x
    public static int[] squares(int x){
        int[] result = new int[x];
        for(int i = 0; i < x; i++){
            result[i] = power2(i + 1);
        }
        return result;
    }
    
    //power 2
    public static int power2(int x){
        return x * x;
    }
}