import java.util.*;

public class DateSort{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x,y,z;
        
        while(true){
            x = scn.nextInt();
            y = scn.nextInt();
            z = scn.nextInt();

            System.out.println(answer(x,y,z));
        }
    }

    public static String answer(int x, int y, int z) { 
        int m,d,r; //month, date, year

        m = min(x,y,z);//obtain month
        
        if(m > 12){
            return "Ambiguous";
        }//month not valid
        
        //get day and year
        if(m == x){
            d = min(y,z);
            if(d == y){
                r = z;
            }
            else r = y;
        }
        else if(m == y){
            d = min(x,z);
            if(d == x){
                r = z;
            }
            else r = x;
        }
        else{
            d = min(x,y);  
            if(d == x){
                r = y;
            }
            else r = x;
        } 
        
        
        //check if date is valid
        if(m == 2){
            if(!(((d <= 28 && d > 12) || (d == m)) && (r > 12 || r == m) && (r > 28 || r == d))){
                return "Ambiguous";
            }//m = 2
        }
        else if(m <= 7 && m != 2){
            if(m % 2 == 0){
                if(!(((d <= 30 && d > 12) || (d == m)) && (r > 12 || r == m) && (r > 30 || r == d))){
                    return "Ambiguous";
                }
            }//m = 4,6
            else{
                if(!(((d <= 31 && d > 12) || (d == m)) && (r > 12 || r == m) && (r > 31 || r == d))){
                    return "Ambiguous";
                }
            }//m = 1,3,5,7
        }
        else{
            if(m % 2 == 0){
                if(!(((d <= 31 && d > 12) || (d == m)) && (r > 12 || r == m) && (r > 31 || r == d))){
                    return "Ambiguous";
                }//m = 8,10,12
            }
            else{
                if(!(((d <= 30 && d > 12) || (d == m)) && (r > 12 || r == m) && (r > 30 || r == d))){
                    return "Ambiguous";
                }//m = 9,11
            }
        }
        
        return NumtoString(m) + "/" + NumtoString(d) + "/" + NumtoString(r);
    }
            
    //convert numbers to string for date
    public static String NumtoString(int x){
        if(x < 10){
            return "0" + x;
        }
        else return "" + x;
    }
            
    //find the min of two numbers
    public static int min(int x, int y){
        if(x > y){
            return y;
        }
        else return x;
    }
            
    //find the min of 3 numbers
    public static int min(int x, int y, int z){
        return min(min(x,y),z);
    }
}