import java.util.*;

public class NameSort{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String[] x = new String[4];
        x[0] = "haha";
        x[1] = "lala";
        x[2] = "zest";
        x[3] = "boo";
        int y;
        while(true){
            y = scn.nextInt();
            String[] answer = answer(x);
            for(int i = 0; i < answer.length; i++){
                System.out.println(answer[i]);
            }
        }
    }

    static class stringNode{
        String name;
        int value;
        public stringNode(String x, int y){
            this.name = x;
            this.value = y;
        }
        
        public int getValue(){
            return this.value;
        }
        
        public String getName(){
            return this.name;
        }
    }
    
    public static String[] answer(String[] names) {
        stringNode[] stringNodeArray = new stringNode[names.length];    
        
        for(int i = 0; i < names.length; i++){
            stringNodeArray[i] = new stringNode(names[i], countString(names[i]));
        }
        
        stringNodeArray = mergeSort(stringNodeArray);
        
        for(int i = 0; i < names.length; i ++){
            names[i] = stringNodeArray[i].getName();
        }
        
        return names;
    }
    
    //initiate mergesort
    public static stringNode[] mergeSort(stringNode[] x){
        if(x.length <= 1){
            return x;
        }
        
        stringNode[] a = new stringNode[x.length / 2];
        stringNode[] b = new stringNode[x.length - a.length];
        
        for(int i = 0; i < x.length; i++){
            if(i < a.length){
                a[i] = x[i];
            }
            else{
                b[i - a.length] = x[i];
            }
        }
        return mergeSort(a, b);
    }

    public static void print(stringNode[] x){
        for(int i = 0; i < x.length; i ++){
            System.out.println(x[i].getName());
        }
    }
    
    //mergesort
    public static stringNode[] mergeSort(stringNode[] x, stringNode[] y){
        //split and call mergesort
        stringNode[] a, b, c, d;
        if(x.length > 1){
            a = new stringNode[x.length / 2];
            b = new stringNode[x.length - a.length];
            
            for(int i = 0; i < x.length; i ++){
                if(i < (x.length)/2){
                    a[i] = x[i];
                }
                else{
                    b[i - a.length] = x[i];
                }
            }
            x = mergeSort(a, b);
        }
        if(y.length > 1){
            c = new stringNode[y.length / 2];
            d = new stringNode[y.length - c.length];
            
            for(int i = 0; i < y.length; i ++){
                if(i < (y.length)/2){
                    c[i] = y[i];
                }
                else{
                    d[i - c.length] = y[i];
                }
            }
            y = mergeSort(c, d);
        }
        
        //sorting starts
        stringNode[] result = new stringNode[x.length + y.length];
        int xl = 0, yl = 0;
        for(int i = 0; i < (x.length + y.length); i ++){
            if(xl >= x.length){
                for(int j = i; j < x.length + y.length; j++){
                    result[j] = y[yl];
                    yl++;
                }
                return result;
            }
            else if(yl >= y.length){
                for(int j = i; j < x.length + y.length; j++){
                    result[j] = x[xl];
                    xl++;
                }
                return result;
            }
            else {
                if(x[xl].getValue() < y[yl].getValue()){
                    result[i] = y[yl];
                    yl++;
                }
                else if(x[xl].getValue() == y[yl].getValue()){
                    String xName = x[xl].getName();
                    String yName = y[yl].getName();
                    
                    if(xName == lexicoCompare(xName, yName)){
                        result[i] = x[xl];
                        xl++;
                    }
                    else{
                        result[i] = y[yl];
                        yl++;
                    }
                }
                else{
                    result[i] = x[xl];
                    xl++;
                }
            }
        }
        return result;
    }
    
    //compare string lexicographically, return larger
    public static String lexicoCompare(String x, String y){
        int i = 0;
        
        while(i < x.length() || i < y.length()){
            if(convert(x.charAt(i)) > convert(y.charAt(i))){
               return x; 
            }
            else if(convert(x.charAt(i)) < convert(y.charAt(i))){
                return y;
            }
            else i++;
        }
        
        return x;
    }
    
    //return the sum of the words
    public static int countString(String x){
        int total = 0;
        
        for(int i = 0; i < x.length(); i++){
            total = total + convert(x.charAt(i));
        }
        
        return total;
    }
    
    //convert char to numbers
    public static int convert(char x){
        switch(x){
            case 'a': return 1; 
            case 'b': return 2; 
            case 'c': return 3; 
            case 'd': return 4; 
            case 'e': return 5; 
            case 'f': return 6; 
            case 'g': return 7; 
            case 'h': return 8; 
            case 'i': return 9; 
            case 'j': return 10; 
            case 'k': return 11; 
            case 'l': return 12; 
            case 'm': return 13; 
            case 'n': return 14; 
            case 'o': return 15; 
            case 'p': return 16; 
            case 'q': return 17; 
            case 'r': return 18; 
            case 's': return 19; 
            case 't': return 20; 
            case 'u': return 21; 
            case 'v': return 22; 
            case 'w': return 23; 
            case 'x': return 24; 
            case 'y': return 25; 
            case 'z': return 26; 
        }
        return 0;
    }
}